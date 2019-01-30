package com.laptrinhjavaweb.security;

public interface AuthenticationFilter {
    String getRedirectUrl();

    static AuthenticationFilter of(String username, String password) {
        return new AuthenticationImpl(username, password);
    }
}
