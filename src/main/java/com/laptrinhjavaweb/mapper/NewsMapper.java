package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.NewsModel;

public class NewsMapper implements RowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet resultSet) {
		try {
			NewsModel model = new NewsModel();
			model.setId(resultSet.getLong("id"));
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
