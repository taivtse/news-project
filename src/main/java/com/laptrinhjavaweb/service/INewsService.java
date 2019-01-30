package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageable;

import java.util.List;

public interface INewsService{
    List<NewsModel> findAll(Pageable pageable);
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel findById(Long id);
    Long save(NewsModel model) throws Exception;
    NewsModel update(NewsModel newModel) throws Exception;
    void delete(Long... ids) throws Exception;
    Long count();
}
