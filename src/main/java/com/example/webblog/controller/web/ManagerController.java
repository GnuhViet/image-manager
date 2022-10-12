package com.example.webblog.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/manage", "/manage/edit"})
public class ManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("/manage".equals(req.getServletPath())) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-manage.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        if("/manage/edit".equals(req.getServletPath())) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/page-editblog.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
