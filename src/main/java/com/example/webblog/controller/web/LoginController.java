package com.example.webblog.controller.web;

import com.example.webblog.model.UserModel;
import com.example.webblog.service.IUserService;
import com.example.webblog.utils.FormUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/login", "/logout", "/register"})
public class LoginController extends HttpServlet {

    @Inject
    private IUserService userService;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/register".equals(req.getServletPath())) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-register.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        if ("/logout".equals(req.getServletPath())) {
            Object obj = req.getSession().getAttribute("UserModel");
            if (obj == null) {
                resp.sendRedirect(req.getContextPath() + "/home");
                return;
            }

            req.getSession().removeAttribute("UserModel");
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }


        String alert = req.getParameter("alert");
        if (alert != null) {
            String message = req.getParameter("message");

            req.setAttribute("message", resourceBundle.getString(message));
            req.setAttribute("alert", alert);
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("/login".equals(req.getServletPath())) {
            UserModel model = FormUtil.toModel(UserModel.class, req);
            model = userService.findByUserNameAndPassword(model.getUsername(), model.getPassword());
            if (model != null) {
                req.getSession().setAttribute("UserModel", model);
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/login?message=usernamePasswordInvalid&alert=warning");
            }
        }
    }
}
