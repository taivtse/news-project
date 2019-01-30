package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public interface INewsService{
    List<NewsModel> findAll(Long offset, Integer limit, String sortExpression, String sortDirection);
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel findById(Long id);
    Long save(NewsModel model) throws Exception;
    NewsModel update(NewsModel newModel) throws Exception;
    void delete(Long... ids) throws Exception;
    Long count();
}
