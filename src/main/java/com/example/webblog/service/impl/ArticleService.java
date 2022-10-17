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
    public Long create(ArticleModel model) {
        return -1L; //articleDAO.create(model);
    }

    @Override
    public ArticleModel read(Long id) {
        return null;
        //return articleDAO.read(id);
    }

    @Override
    public boolean update(ArticleModel model) {
        return false;//articleDAO.update(model);
    }

    @Override
    public boolean delete(Long id) {
        return false; //articleDAO.delete(id);
    }
}
