package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>{

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel model = new CategoryModel();
			model.setId(resultSet.getLong("id"));
			model.setCode(resultSet.getString("code"));
			model.setName(resultSet.getString("name"));
			return model;
		} catch (SQLException e) {
			return null;
		}
	}

}
