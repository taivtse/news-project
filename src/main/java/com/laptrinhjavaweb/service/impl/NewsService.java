package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;

import javax.inject.Inject;
import java.util.List;

public class NewsService implements INewsService{

    @Inject
    INewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }
}
