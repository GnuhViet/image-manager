package com.example.webblog.controller.web.api;

import com.example.webblog.model.ArticleModel;
import com.example.webblog.service.impl.ArticleService;
import com.example.webblog.utils.HttpUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-article"})
public class ArticleApi extends HttpServlet {
    @Inject
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ArticleModel model = HttpUtil.of(req.getReader()).toModel(ArticleModel.class);
        ArticleModel res = articleService.read(model.getId());
        mapper.writeValue(resp.getOutputStream(), res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        ArticleModel model = HttpUtil.of(req.getReader()).toModel(ArticleModel.class);
        String res = articleService.create(model);
        mapper.writeValue(resp.getOutputStream(), res);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
