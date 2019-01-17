package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.CommentModel;

public interface ICommentService {
    CommentModel findById(Long id);
    Long save(CommentModel model) throws Exception;
    CommentModel update(CommentModel newModel) throws Exception;
    void delete(Long... ids) throws Exception;
    void deleteByNewsId(Long id) throws Exception;
}
