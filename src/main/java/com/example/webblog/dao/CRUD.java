package com.example.webblog.dao;

import com.example.webblog.model.UserModel;

public interface CRUD<T> {
    String create(T tModel);
    UserModel read(Long id);
    String update(T tModel);
    String delete(Long id);
}
