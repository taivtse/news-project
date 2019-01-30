package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.mapper.impl.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return this.query(sql, new CategoryMapper());
    }

}
