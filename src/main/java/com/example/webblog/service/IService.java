package com.example.webblog.service;

public interface IService<T> {
    String create(T model);
    T read(Long id);
    String update(T model);
    String delete(Long id);
}
