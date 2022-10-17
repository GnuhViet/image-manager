package com.example.webblog.service;

public interface IService<T> {
    Long create(T model);
    T read(Long id);
    boolean update(T model);
    boolean delete(Long id);
}
