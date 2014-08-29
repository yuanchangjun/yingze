package com.baldurtech;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action{
    final ServletContext servletContext;
    final HttpServletRequest request;
    final HttpServletResponse response;

    public Action(){
        this(null,null,null);
    }
    
    public Action(ServletContext servletContext,HttpServletRequest request,HttpServletResponse response){
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }

    public String getViewPage(String uri){
        return "/WEB-INF/jsp" + uri;
    }
}
