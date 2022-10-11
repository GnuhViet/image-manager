package com.example.webblog.dao.impl;

import com.example.webblog.dao.IArticleDAO;
import com.example.webblog.mapper.impl.ArticleMapper;
import com.example.webblog.model.ArticleModel;
import com.example.webblog.model.UserModel;

import java.util.List;

public class ArticleDAO extends AbstractDAO<ArticleModel> implements IArticleDAO {
    @Override
    public List<ArticleModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM article WHERE categoryId = ?";
        return read(sql, new ArticleMapper(), categoryId);
    }

    @Override
    public String create(ArticleModel articleModel) {
        return null;
    }

    @Override
    public UserModel read(Long id) {
        return null;
    }

    @Override
    public String update(ArticleModel articleModel) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}
