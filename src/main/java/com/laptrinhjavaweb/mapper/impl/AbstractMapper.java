package com.laptrinhjavaweb.mapper.impl;

import com.laptrinhjavaweb.model.AbstractModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractMapper<T extends AbstractModel> {
    protected void abstractModelMapRow(ResultSet resultSet, T model) {
        try {
            model.setId(resultSet.getLong("id"));
            model.setCreatedDate(resultSet.getTimestamp("created_date"));
            model.setModifiedDate(resultSet.getTimestamp("modified_date"));
            model.setCreatedBy(resultSet.getString("created_by"));
            model.setModifiedBy(resultSet.getString("modified_by"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
