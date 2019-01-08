package com.laptrinhjavaweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.mapper.IRowMapper;
import com.laptrinhjavaweb.model.NewsModel;

public class NewsMapper extends AbstractMapper implements IRowMapper<NewsModel> {

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel model = new NewsModel();
			this.abstractModelMapRow(resultSet, model);

			model.setTitle(resultSet.getString("title"));
			model.setThumbnail(resultSet.getString("thumbnail"));
			model.setDescription(resultSet.getString("description"));
			model.setContent(resultSet.getString("content"));
			model.setCategoryId(resultSet.getLong("category_id"));
			return model;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
