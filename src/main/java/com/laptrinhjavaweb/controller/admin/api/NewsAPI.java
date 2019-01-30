package com.laptrinhjavaweb.controller.admin.api;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.util.HttpUtil;
import com.laptrinhjavaweb.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-admin-news"})
public class NewsAPI extends HttpServlet {

    @Inject
    private INewsService newsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

        UserModel loginModel = (UserModel) SessionUtil.getInstance().getAttribute(req, SystemConstant.SESSION_USER);
        newsModel.setCreatedBy(loginModel.getUsername());

        try {
            Long id = newsService.save(newsModel);
            newsModel = newsService.findById(id);
            HttpUtil.writeValue(resp.getOutputStream(), newsModel);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

        UserModel loginModel = (UserModel) SessionUtil.getInstance().getAttribute(req, SystemConstant.SESSION_USER);
        newsModel.setModifiedBy(loginModel.getUsername());

        try {
            newsModel = newsService.update(newsModel);
            HttpUtil.writeValue(resp.getOutputStream(), newsModel);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewsModel newsModel = HttpUtil.of(req.getReader()).toModel(NewsModel.class);

        try {
            newsService.delete(newsModel.getIds());
            HttpUtil.writeValue(resp.getOutputStream(), "{}");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }


}
