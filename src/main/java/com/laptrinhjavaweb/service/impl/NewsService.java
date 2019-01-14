package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService{

    @Inject
    INewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }

    @Override
    public Long save(NewsModel model) {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        return newsDAO.save(model);
    }
}
