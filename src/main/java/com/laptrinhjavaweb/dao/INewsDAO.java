package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public interface INewsDAO extends IGenericDAO<NewsModel> {
    List<NewsModel> findAll(Long offset, Long limit);

    List<NewsModel> findByCategoryId(Long categoryId);

    NewsModel findById(Long id);

    Long save(NewsModel model) throws Exception;

    void update(NewsModel model) throws Exception;

    void delete(Long id) throws Exception;

    Long count();
}
