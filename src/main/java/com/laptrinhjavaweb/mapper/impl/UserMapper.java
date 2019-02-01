package com.laptrinhjavaweb.mapper.impl;

import com.laptrinhjavaweb.mapper.IRowMapper;
import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper extends AbstractMapper implements IRowMapper<UserModel> {

    @Override
    public UserModel mapRow(ResultSet resultSet) {
        try {
            UserModel userModel = new UserModel();
            this.abstractModelMapRow(resultSet, userModel);
            userModel.setUsername(resultSet.getString("username"));
            userModel.setPassword(resultSet.getString("password"));
            userModel.setFullName(resultSet.getString("fullname"));
            userModel.setActive(resultSet.getBoolean("is_active"));

            try {
                RoleModel roleModel = new RoleModel();
                roleModel.setId(resultSet.getLong("role_id"));
                roleModel.setName(resultSet.getString("role_name"));
                roleModel.setCode(resultSet.getString("role_code"));
                userModel.setRole(roleModel);
            }catch (SQLException ignore) {
                System.out.println(ignore.getMessage());
            }

            return userModel;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
