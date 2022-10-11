package com.example.webblog.controller.web;

import com.example.webblog.model.UserModel;
import com.example.webblog.service.impl.UserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/about", "/category", "/contact", "/home", "/profile",
        "/styles", "/audio", "/gallery", "/standard", "/video"})
public class HomeController extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if("/profile".equals(req.getServletPath())) {
            Object obj = req.getSession().getAttribute("UserModel");
            if (obj == null) {
                resp.sendRedirect(req.getContextPath() + "/home");
                return;
            }
            UserModel userModel = userService.findById(((UserModel)obj).getId());
            req.setAttribute("UserModel", userModel);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-" + req.getServletPath().replace("/", "") + ".jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
