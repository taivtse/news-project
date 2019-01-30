package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService {
    @Inject
    private IUserDao userDao;

    @Override
    public UserModel findActiveUserByUsernameAndPassword(String username, String password) {
        return userDao.findActiveUserByUsernameAndPassword(username, password);
    }
}
