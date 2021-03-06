package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewsDao;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.INewsService;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;

public class NewsService implements INewsService {

    @Inject
    INewsDao newsDAO;

    @Override
    public List<NewsModel> findAll(Pageable pageable) {
        return newsDAO.findAll(pageable);
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
        return newsDAO.save(model);
    }

    @Override
    public NewsModel update(NewsModel newModel) throws Exception {
        NewsModel oldModel = this.findById(newModel.getId());
        newModel.setCreatedDate(oldModel.getCreatedDate());
        newModel.setCreatedBy(oldModel.getCreatedBy());
        newModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));

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

    @Override
    public Long count() {
        return newsDAO.count();
    }

}
