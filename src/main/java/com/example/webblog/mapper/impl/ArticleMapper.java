package com.example.webblog.mapper.impl;

import com.example.webblog.model.ArticleModel;

import java.sql.ResultSet;

public class ArticleMapper extends AbstractMapper<ArticleModel>{

    @Override
    public ArticleModel mapRow(ResultSet rs) {
        return newMappedInstance(ArticleModel.class, rs);
    }
}
