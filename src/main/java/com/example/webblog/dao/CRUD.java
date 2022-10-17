package com.example.webblog.dao;

import com.example.webblog.model.UserModel;

public interface CRUD<T> {
    Long create(T tModel);
    T read(Long id);
    boolean update(T tModel);
    boolean delete(Long id);
}
