package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.impl.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO{

    @Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE category_id = ?";
		return this.query(sql, new NewsMapper(), categoryId);
	}

    @Override
	public Long save(NewsModel model){
        String sql = "INSERT INTO news VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return this.insert(sql, model.getTitle(), model.getThumbnail(), model.getDescription(),
                model.getContent(), model.getCreatedDate(), model.getModifiedDate(),
                model.getCreatedBy(), model.getModifiedBy(), model.getCategoryId());
    }

    @Override
    public Long update(NewsModel model) {
        String sql = "UPDATE news SET title = ?, thumbnail = ?, description = ?, " +
                "content = ?, modified_date = ?, modified_by = ?, category_id = ?";
        return this.insert(sql, model.getTitle(), model.getThumbnail(), model.getDescription(),
                model.getContent(), model.getModifiedDate(), model.getModifiedBy(), model.getCategoryId());
    }

}
