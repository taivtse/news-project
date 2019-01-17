package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.impl.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        return this.query(sql, new CategoryMapper());
    }

}
