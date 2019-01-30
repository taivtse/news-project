package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
    UserModel findActiveUserByUsernameAndPassword(String username, String password);
}
