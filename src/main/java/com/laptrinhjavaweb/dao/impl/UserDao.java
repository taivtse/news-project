package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.mapper.impl.UserMapper;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageable;

import javax.inject.Inject;
import java.util.List;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {

    @Override
    public UserModel findActiveUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT u.*, r.name role_name, r.code role_code FROM user u " +
                "INNER JOIN role r ON u.role_id = r.id " +
                "WHERE username = ? AND password = ? AND is_active = 1";
        List<UserModel> modelList = this.query(sql, new UserMapper(), username, password);

        return modelList.isEmpty() ? null : modelList.get(0);
    }

    @Override
    public List<UserModel> findAll(Pageable pageable) {
        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM user");
        if (pageable.getSorter().getSortExpression() != null && pageable.getSorter().getSortDirection() != null) {
            sqlBuilder.append(" ORDER BY " + pageable.getSorter().getSortExpression() + " " + pageable.getSorter().getSortDirection());
        }

        if (pageable.getOffset() != null && pageable.getLimit() != null) {
            sqlBuilder.append(" LIMIT " + pageable.getLimit() + " OFFSET " + pageable.getOffset());
        }

        return this.query(sqlBuilder.toString(), new UserMapper());
    }

    @Override
    public UserModel findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<UserModel> modelList = this.query(sql, new UserMapper(), id);
        return modelList.isEmpty() ? null : modelList.get(0);
    }

    @Override
    public Long save(UserModel model) throws Exception {
        return null;
    }

    @Override
    public UserModel update(UserModel newModel) throws Exception {
        return null;
    }

    @Override
    public void delete(Long... ids) throws Exception {

    }

    @Override
    public Long count() {
        return null;
    }
}
