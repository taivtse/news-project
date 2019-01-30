package com.laptrinhjavaweb.security;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationFilter {
    String getRedirectUrl(HttpServletRequest request);

    static AuthenticationFilter of(String username, String password) {
        return new AuthenticationImpl(username, password);
    }
}
