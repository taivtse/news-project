package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin-home"})
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
        NewsModel model = new NewsModel();
        model.setTitle("title1");
        model.setContent("content2");
        model.setCategoryId(2L);

        newsService.save(model);


		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	

}
