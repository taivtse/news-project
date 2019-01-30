package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.mapper.impl.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

import java.util.List;

public class UserDao extends AbstractDao<UserModel> implements IUserDao {
    @Override
    public UserModel findActiveUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT u.*, r.name role_name, r.code role_code FROM user u " +
                "INNER JOIN role r ON u.role_id = r.id " +
                "WHERE username = ? AND password = ? AND is_active = 1";
        List<UserModel> modelList = this.query(sql, new UserMapper(), username, password);

        if (modelList.size() > 0 && modelList.get(0) != null) {
            return modelList.get(0);
        }
        return null;
    }
}
