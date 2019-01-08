package com.laptrinhjavaweb.mapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.mapper.IRowMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper extends AbstractMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet resultSet) {
		try {
			CategoryModel model = new CategoryModel();
			this.abstractModelMapRow(resultSet, model);

			model.setCode(resultSet.getString("code"));
			model.setName(resultSet.getString("name"));
			return model;
		} catch (SQLException e) {
			return null;
		}
	}

}
