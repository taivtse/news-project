package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewsService newsService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModel> categoryModels = categoryService.findAll();
		List<NewsModel> newsModels = newsService.findByCategoryId(1L);
		req.setAttribute("test", categoryModels);
		req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
