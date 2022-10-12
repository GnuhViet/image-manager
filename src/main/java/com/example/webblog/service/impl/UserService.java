package com.example.webblog.service.impl;

import com.example.webblog.dao.IUserDAO;
import com.example.webblog.model.UserModel;
import com.example.webblog.service.IUserService;
import com.example.webblog.utils.ImageUtil;

import javax.inject.Inject;
import java.sql.Timestamp;

public class UserService implements IUserService {
    @Inject
    private IUserDAO userDAO;

    @Override
    public UserModel findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public UserModel findByUserNameAndPassword(String username, String password) {
        return userDAO.findByUserNameAndPassword(username, password);
    }

    @Override
    public String create(UserModel userModel) {
        userModel.setCreateDate(new Timestamp(System.currentTimeMillis()));
        userModel.setAvatar("user.png");
        userModel.setStatus(1);
        userModel.setRoleId(1L);
        return userDAO.create(userModel);
    }

    @Override
    public UserModel read(Long id) {
        return userDAO.read(id);
    }

    @Override
    public String update(UserModel updateModel) {
        UserModel old = findById(updateModel.getId());

        if (updateModel.getAvatar() == null) {
            updateModel.setAvatar(old.getAvatar());
        } else {
            updateModel.setAvatar(ImageUtil.saveUserImage(updateModel.getId(), updateModel.getAvatar()));
        }

        updateModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return userDAO.update(updateModel);
    }

    @Override
    public String delete(Long id) {
        return userDAO.delete(id);
    }
}
