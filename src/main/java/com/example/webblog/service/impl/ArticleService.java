package com.example.webblog.service.impl;

import com.example.webblog.dao.IArticleDAO;
import com.example.webblog.model.ArticleModel;
import com.example.webblog.service.IArticleService;

import javax.inject.Inject;
import java.util.List;

public class ArticleService implements IArticleService {

    @Inject
    private IArticleDAO articleDAO;

    @Override
    public List<ArticleModel> findByCategoryId(Long categoryId) {
        return articleDAO.findByCategoryId(categoryId);
    }

    @Override
    public String create(ArticleModel model) {
        return null; //articleDAO.create(model);
    }

    @Override
    public ArticleModel read(Long id) {
        return null;
        //return articleDAO.read(id);
    }

    @Override
    public String update(ArticleModel model) {
        return null;//articleDAO.update(model);
    }

    @Override
    public String delete(Long id) {
        return null; //articleDAO.delete(id);
    }
}
