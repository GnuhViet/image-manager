package com.example.webblog.dao;

import com.example.webblog.model.ArticleModel;

import java.util.List;

public interface IArticleDAO extends CRUD<ArticleModel> {
    List<ArticleModel> findByCategoryId(Long categoryId);
}
