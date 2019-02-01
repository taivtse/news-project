package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.AbstractModel;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.security.AuthenticationFilter;
import com.laptrinhjavaweb.util.FormUtil;
import com.laptrinhjavaweb.util.ResourceBundleUtil;
import com.laptrinhjavaweb.util.SessionUtil;
import com.laptrinhjavaweb.util.message.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/dang-nhap", "/dang-xuat"})
public class AuthController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractModel model = FormUtil.populate(AbstractModel.class, req);
        if (model.getMessage() != null && model.getAlert() != null){
            MessageUtil.of(ResourceBundleUtil.getString(model.getMessage()), model.getAlert()).buildMessage(req);
        }

        if (req.getRequestURI().startsWith("/dang-nhap")) {
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        } else if (req.getRequestURI().startsWith("/dang-xuat")) {
            SessionUtil.getInstance().removeAttribute(req, SystemConstant.SESSION_USER);
            resp.sendRedirect("/trang-chu");
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

    private void buildMessageResponse(HttpServletRequest req){

    }
}
