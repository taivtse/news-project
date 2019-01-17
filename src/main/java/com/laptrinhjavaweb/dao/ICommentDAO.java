package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.CommentModel;

public interface ICommentDAO extends IGenericDAO<CommentModel> {
    void delete(Long id) throws Exception;
    void deleteByNewsId(Long id) throws Exception;
}
