package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.dao.impl.UserDao;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    @Override
    public UserModel findActiveUserByUsernameAndPassword(String username, String password) {
        return userDao.findActiveUserByUsernameAndPassword(username, password);
    }
}
