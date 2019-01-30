package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.CommentModel;

public interface ICommentDao extends IGenericDao<CommentModel> {
    void delete(Long id) throws Exception;
    void deleteByNewsId(Long id) throws Exception;
}
