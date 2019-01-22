package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {

    @Inject
    private INewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsModel model = FormUtil.populate(NewsModel.class, req);

        model.setTotalItems(newsService.count());
        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));

        Long offset = (model.getPage() - 1) * model.getMaxPageItems();
        model.setListResult(newsService.findAll(offset, model.getMaxPageItems()));

        req.setAttribute(SystemConstant.MODEL, model);
        req.getRequestDispatcher("/views/admin/news/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
