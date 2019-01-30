package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.security.AuthenticationFilter;
import com.laptrinhjavaweb.util.FormUtil;
import com.laptrinhjavaweb.util.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/dang-nhap"})
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().startsWith("/dang-nhap")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (req.getRequestURI().startsWith("/dang-xuat")) {
            SessionUtil.getInstance().removeAttribute(req, SystemConstant.SESSION_USER);
        } else {
            resp.sendRedirect("/trang-chu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserModel model = FormUtil.populate(UserModel.class, req);
        String redirectUrl = AuthenticationFilter.of(model.getUsername(), model.getPassword()).getRedirectUrl(req);
        resp.sendRedirect(redirectUrl);
    }
}
