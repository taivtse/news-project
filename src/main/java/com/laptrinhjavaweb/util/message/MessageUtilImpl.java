package com.laptrinhjavaweb.util.message;

import com.laptrinhjavaweb.constant.SystemConstant;

import javax.servlet.http.HttpServletRequest;

public class MessageUtilImpl implements MessageUtil {

    private String message;
    private String alert;

    public MessageUtilImpl(String message, String alert) {
        this.message = message;
        this.alert = alert;
    }

    @Override
    public void buildMessage(HttpServletRequest request) {
        request.setAttribute(SystemConstant.MESSAGE_RESPONSE, this.message);
        request.setAttribute(SystemConstant.ALERT, this.alert);
    }
}