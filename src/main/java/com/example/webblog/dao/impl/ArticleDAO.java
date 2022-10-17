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
    public Long create(ArticleModel articleModel) {
        return null;
    }

    @Override
    public ArticleModel read(Long id) {
        return null;
    }

    @Override
    public boolean update(ArticleModel articleModel) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
