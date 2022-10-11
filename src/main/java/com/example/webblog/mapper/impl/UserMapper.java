package com.example.webblog.mapper.impl;

import com.example.webblog.model.UserModel;

import java.sql.ResultSet;

public class UserMapper extends AbstractMapper<UserModel> {
    @Override
    public UserModel mapRow(ResultSet rs) {
        return newMappedInstance(UserModel.class, rs);
    }
}
