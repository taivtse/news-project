package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.util.FormUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class AuthController extends HttpServlet {
    @Inject
    private IUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().equals("/dang-nhap")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (req.getRequestURI().equals("/dang-xuat")) {

        } else {
            resp.sendRedirect("/trang-chu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserModel model = FormUtil.populate(UserModel.class, req);
        UserModel loginModel = userService.findActiveUserByUsernameAndPassword(model.getUsername(), model.getPassword());
        if (loginModel != null) {
            if (loginModel.getRole().getCode().equals("admin")){
                resp.sendRedirect("/admin-home");
            }else {
                resp.sendRedirect("/trang-chu");
            }
        } else {
            resp.sendRedirect("/dang-nhap");
        }
    }
}
