package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;

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
        NewsModel model = new NewsModel();
        model.setListResult(newsService.findAll());
        model.setTotalItems(model.getListResult().size());
        model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getMaxPageItems()));

        String page = req.getParameter("page");
        if (page != null) {
            model.setPage(Integer.parseInt(page));
        }

        req.setAttribute(SystemConstant.MODEL, model);
        req.getRequestDispatcher("/views/admin/news/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
