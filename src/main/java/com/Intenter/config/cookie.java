package com.Intenter.config;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class cookie {

    public void setCookie(HttpServletResponse response, String key, String value){
        Cookie cookie = new Cookie(key, value);
        response.addCookie(cookie);
    }
}
