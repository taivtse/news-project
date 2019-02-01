package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;

public interface IUserDao extends IGenericDao<UserModel> {
    UserModel findActiveUserByUsernameAndPassword(String username, String password);
    List<UserModel> findAll(Pageable pageable);
    UserModel findById(Long id);
    Long save(UserModel model) throws Exception;
    UserModel update(UserModel newModel) throws Exception;
    void delete(Long... ids) throws Exception;
    Long count();
}
