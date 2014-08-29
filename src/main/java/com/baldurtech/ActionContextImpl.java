package com.baldurtech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionContextImpl implements ActionContext{

    final ServletContext servletContext;
    final HttpServletRequest request;
    final HttpServletResponse response;

    public ActionContextImpl(ServletContext servletContext,HttpServletRequest request,HttpServletResponse response){
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }
    
    public void setAttribute(String key, Object value){
        request.setAttribute(key, value);
    }
}

