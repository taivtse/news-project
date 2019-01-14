package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;

public interface INewsDAO extends IGenericDAO<NewsModel> {
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel model);
    Long update(NewsModel model);
}
