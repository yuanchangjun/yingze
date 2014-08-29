package com.baldurtech;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action{
    final ActionContext actionContext;

    public Action(ActionContext actionContext){
        this.actionContext = actionContext;
    }
    
    public void setAttribute(String key, Object value){
        actionContext.setAttribute(key, value);
    }
}
