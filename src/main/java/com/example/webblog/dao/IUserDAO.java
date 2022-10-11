package com.example.webblog.dao;

import com.example.webblog.model.UserModel;

public interface IUserDAO extends CRUD<UserModel>{
    UserModel findById(Long id);
    UserModel findByUserNameAndPassword(String username, String password);
}
