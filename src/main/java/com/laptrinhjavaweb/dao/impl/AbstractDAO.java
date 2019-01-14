package com.laptrinhjavaweb.dao.impl;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.IGenericDAO;
import com.laptrinhjavaweb.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T> {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/news-project";
            String user = "root";
            String password = "123456789";
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement, parameters);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                results.add(rowMapper.mapRow(resultSet));
            }

            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            setParameters(preparedStatement, parameters);

            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                if (connection != null) {
                    try {
                        connection.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                e.printStackTrace();
            }
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long generateId = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            setParameters(preparedStatement, parameters);
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                generateId = resultSet.getLong(1);
            }
            connection.commit();
            return generateId;
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void setParameters(PreparedStatement preparedStatement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;

                if (parameter instanceof Byte) {
                    preparedStatement.setByte(index, (Byte) parameter);

                } else if (parameter instanceof Short) {
                    preparedStatement.setShort(index, (Short) parameter);

                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) parameter);

                } else if (parameter instanceof Long) {
                    preparedStatement.setLong(index, (Long) parameter);

                } else if (parameter instanceof Float) {
                    preparedStatement.setFloat(index, (Float) parameter);

                } else if (parameter instanceof Double) {
                    preparedStatement.setDouble(index, (Double) parameter);

                } else if (parameter instanceof BigDecimal) {
                    preparedStatement.setBigDecimal(index, (BigDecimal) parameter);

                } else if (parameter instanceof String) {
                    preparedStatement.setString(index, (String) parameter);

                } else if (parameter instanceof Date) {
                    preparedStatement.setDate(index, (Date) parameter);

                } else if (parameter instanceof Time) {
                    preparedStatement.setTime(index, (Time) parameter);

                } else if (parameter instanceof Timestamp) {
                    preparedStatement.setTimestamp(index, (Timestamp) parameter);

                } else if (parameter == null) {
                    preparedStatement.setNull(index, java.sql.Types.INTEGER);
                } else {
                    throw new Exception("Chưa hỗ trợ parameter có kiểu: " + parameter.getClass().getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
