package com.example.webblog.controller.web.api;

import com.example.webblog.model.FolderModel;
import com.example.webblog.model.UserModel;
import com.example.webblog.service.IFolderService;
import com.example.webblog.service.IUserService;
import com.example.webblog.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-user"})
public class UserApi extends HttpServlet {
    @Inject
    private IUserService userService;

    @Inject
    private IFolderService folderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        UserModel res = userService.read(userModel.getId());
        new ObjectMapper().writeValue(resp.getOutputStream(), res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserModel userModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        Long id = userService.create(userModel);
        String message = (id != null ? "success" : "fail");

        if ("success".equals(message)){
            FolderModel userFolder = new FolderModel();
            userFolder.setUserId(id);
            folderService.create(userFolder);
        }

        new ObjectMapper().writeValue(resp.getOutputStream(), message);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserModel updateModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        String message = userService.update(updateModel) ? "success" : "fail";

        //update session if update profile success
        if ("success".equals(message)) {
            req.getSession().removeAttribute("UserModel");
            req.getSession().setAttribute("UserModel", userService.findById(updateModel.getId()));
        }

        new ObjectMapper().writeValue(resp.getOutputStream(), message);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        UserModel deleteModel = HttpUtil.of(req.getReader()).toModel(UserModel.class);
        String message = userService.delete(deleteModel.getId()) ? "success" : "fail";
        new ObjectMapper().writeValue(resp.getOutputStream(), message);
    }
}
