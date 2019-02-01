package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.IUserDao;
import com.laptrinhjavaweb.dao.impl.UserDao;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IUserService;

import javax.inject.Inject;
import java.util.List;

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

    @Override
    public List<UserModel> findAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public UserModel findById(Long id) {
        return userDao.findById(id);
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
