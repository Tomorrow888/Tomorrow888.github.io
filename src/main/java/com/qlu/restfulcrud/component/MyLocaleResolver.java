package com.qlu.restfulcrud.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author jiajinshuo
 * @create 2020-02-08 15:00
 */
public class MyLocaleResolver implements LocaleResolver {
    Locale locale = Locale.getDefault();
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            locale = new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
