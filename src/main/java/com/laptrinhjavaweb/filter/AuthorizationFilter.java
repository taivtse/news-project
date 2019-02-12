package com.laptrinhjavaweb.filter;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith("/admin")) {
            UserModel loginModel = (UserModel) SessionUtil.getInstance().getAttribute(request, SystemConstant.SESSION_USER);
            if (loginModel != null) {
                if (loginModel.getRole().getCode().equals(SystemConstant.ROLE_ADMIN)) {
                    filterChain.doFilter(servletRequest, servletResponse);
                } else if (loginModel.getRole().getCode().equals(SystemConstant.ROLE_USER)) {
                    response.sendRedirect("/dang-nhap?message=no_permission");
                }
            } else {
                response.sendRedirect("/dang-nhap?message=no_login");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
