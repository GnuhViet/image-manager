package com.example.webblog.service;

import com.example.webblog.model.ArticleModel;

import java.util.List;

public interface IArticleService extends IService<ArticleModel>{
    List<ArticleModel> findByCategoryId(Long categoryId);
}
