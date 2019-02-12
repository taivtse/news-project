package com.laptrinhjavaweb.security;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.UserService;
import com.laptrinhjavaweb.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements AuthenticationFilter {
    private IUserService userService;

    private String username;
    private String password;

    public AuthenticationImpl(String username, String password) {
        this.username = username;
        this.password = password;
        this.userService = new UserService();
    }

    @Override
    public String getRedirectUrl(HttpServletRequest request) {
        UserModel loginModel = userService.findActiveUserByUsernameAndPassword(this.username, this.password);
        if (loginModel != null) {
            SessionUtil.getInstance().putAttribute(request, SystemConstant.SESSION_USER, loginModel);
            if (loginModel.getRole().getCode().equals("admin")) {
                return "/admin-home";
            } else {
                return "/trang-chu";
            }
        } else {
            return "/dang-nhap?message=login_wrong";
        }
    }
}
