package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.model.CommentModel;

public class CommentDAO extends AbstractDAO<CommentModel> implements ICommentDAO {
    @Override
    public void delete(Long id) throws Exception {
        String sql = "DELETE FROM comment WHERE id = ?";
        this.modifiedData(sql, id);
    }

    @Override
    public void deleteByNewsId(Long id) throws Exception {
        String sql = "DELETE FROM comment WHERE news_id = ?";
        this.modifiedData(sql, id);
    }
}
