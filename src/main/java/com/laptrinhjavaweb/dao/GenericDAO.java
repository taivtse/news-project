package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.mapper.IRowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
}
