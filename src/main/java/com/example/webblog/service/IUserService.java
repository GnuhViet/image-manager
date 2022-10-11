package com.example.webblog.service;

import com.example.webblog.model.UserModel;

public interface IUserService extends IService<UserModel> {
    UserModel findById(Long id);
    UserModel findUserIdByUserNameAndPassword(String username, String password);
}
