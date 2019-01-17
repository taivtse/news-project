package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.ICommentDAO;
import com.laptrinhjavaweb.model.CommentModel;
import com.laptrinhjavaweb.service.ICommentService;

import javax.inject.Inject;

public class CommentService implements ICommentService {

    @Inject
    ICommentDAO commentDAO;

    @Override
    public CommentModel findById(Long id) {
        return null;
    }

    @Override
    public Long save(CommentModel model) throws Exception {
        return null;
    }

    @Override
    public CommentModel update(CommentModel newModel) throws Exception {
        return null;
    }

    @Override
    public void delete(Long... ids) throws Exception {
        for (Long id : ids) {
            commentDAO.delete(id);
        }
    }

    @Override
    public void deleteByNewsId(Long id) throws Exception {

    }
}
