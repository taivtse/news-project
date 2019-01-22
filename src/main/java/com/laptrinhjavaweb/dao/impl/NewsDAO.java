package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.impl.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

    @Override
    public List<NewsModel> findAll(Long offset, Long limit) {
        String sql = "SELECT * FROM news LIMIT ? OFFSET ?";
        return this.query(sql, new NewsMapper(), limit, offset);
    }

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE category_id = ?";
        return this.query(sql, new NewsMapper(), categoryId);
    }

    @Override
    public NewsModel findById(Long id) {
        String sql = "SELECT * FROM news WHERE id = ?";
        return this.query(sql, new NewsMapper(), id).get(0);
    }

    @Override
    public Long save(NewsModel model) throws Exception {
        String sql = "INSERT INTO news VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return this.insertData(sql, model.getTitle(), model.getThumbnail(), model.getDescription(),
                model.getContent(), model.getCreatedDate(), model.getModifiedDate(),
                model.getCreatedBy(), model.getModifiedBy(), model.getCategoryId());
    }

    @Override
    public void update(NewsModel model) throws Exception {
        String sql = "UPDATE news SET title = ?, thumbnail = ?, description = ?, " +
                "content = ?, modified_date = ?, modified_by = ?, category_id = ? WHERE id = ?";
        this.modifiedData(sql, model.getTitle(), model.getThumbnail(), model.getDescription(),
                model.getContent(), model.getModifiedDate(), model.getModifiedBy(), model.getCategoryId(), model.getId());
    }

    @Override
    public void delete(Long id) throws Exception {
        String sql = "DELETE FROM news WHERE id = ?";
        this.modifiedData(sql, id);
    }

    @Override
    public Long count() {
        String sql = "SELECT COUNT(*) FROM news";
        return this.count(sql);
    }

}
