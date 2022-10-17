package com.example.webblog.dao.impl;

import com.example.webblog.dao.IUserDAO;
import com.example.webblog.mapper.impl.UserMapper;
import com.example.webblog.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO{

    public static final String createQuery =
            "INSERT INTO user(username, password, fullName, email, phone, avatar, status, createDate, roleId) " +
                    "VALUES (?,?,?,?,?,?,?,?,?)";

    public static final String updateQuery =
            "UPDATE user SET password = ?, fullName = ?, email = ?, phone = ?, avatar = ?, modifiedDate = ?  WHERE id = ?";

    @Override
    public UserModel findById(Long id) {
        String sql = "SELECT user.* from user WHERE id = ?";
        List<UserModel> users = read(sql, new UserMapper(), id);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public UserModel findByUserNameAndPassword(String username, String password) {
        String sql = "SELECT user.* from user WHERE username = ? AND password = ?";
        List<UserModel> users = read(sql, new UserMapper(), username, password);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public Long create(UserModel userModel) {
        return update(createQuery,
                userModel.getUsername(),
                userModel.getPassword(),
                userModel.getFullName(),
                userModel.getEmail(),
                userModel.getPhone(),
                userModel.getAvatar(),
                userModel.getStatus(),
                userModel.getCreateDate(),
                userModel.getRoleId());
    }

    @Override
    public UserModel read(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<UserModel> users = read(sql, new UserMapper(), id);

        if (users != null) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean update(UserModel updateModel) {
        Long updateId = update(updateQuery,
                updateModel.getPassword(),
                updateModel.getFullName(),
                updateModel.getEmail(),
                updateModel.getPhone(),
                updateModel.getAvatar(),
                updateModel.getModifiedDate(),
                updateModel.getId());
        return updateId == 1L;
    }

    @Override
    public boolean delete(Long id) {
        Long deleteId = update("Update user SET status = 0 WHERE id = ?" , id);
        return deleteId == 1L;
    }

}
