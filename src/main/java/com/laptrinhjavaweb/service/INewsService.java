package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public interface INewsService{
    List<NewsModel> findByCategoryId(Long categoryId);
    Long save(NewsModel newsModel);
}
