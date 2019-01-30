package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDao extends IGenericDao<UserModel> {
    UserModel findActiveUserByUsernameAndPassword(String username, String password);
}
