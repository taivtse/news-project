package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService {

    @Inject
    INewsDAO newsDAO;

    @Override
    public List<NewsModel> findAll() {
        return newsDAO.findAll();
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel findById(Long id) {
        return newsDAO.findById(id);
    }

    @Override
    public Long save(NewsModel model) throws Exception {
        model.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        model.setCreatedBy("");
        return newsDAO.save(model);
    }

    @Override
    public NewsModel update(NewsModel newModel) throws Exception {
        NewsModel oldModel = this.findById(newModel.getId());
        newModel.setCreatedDate(oldModel.getCreatedDate());
        newModel.setCreatedBy(oldModel.getCreatedBy());
        newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        newModel.setModifiedBy("");

        newsDAO.update(newModel);

        return this.findById(newModel.getId());
    }

    @Override
    public void delete(Long... ids) throws Exception {
        for (Long id : ids) {
//            delete comment before delete news
            newsDAO.delete(id);
        }
    }

}
