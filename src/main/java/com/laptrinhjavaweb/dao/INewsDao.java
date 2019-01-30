package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;

public interface INewsDao extends IGenericDao<NewsModel> {
    List<NewsModel> findAll(Pageable pageable);

    List<NewsModel> findByCategoryId(Long categoryId);

    NewsModel findById(Long id);

    Long save(NewsModel model) throws Exception;

    void update(NewsModel model) throws Exception;

    void delete(Long id) throws Exception;

    Long count();
}
