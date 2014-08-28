package com.baldurtech;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class DispatchServlet extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse resp) 
        throws IOException,ServletException{        
        
    }
    public String getActionClassNameByUri(String uri){
        String[] uriParts = uri.split("/");
        String actionClassName = uriParts[1];
        actionClassName = actionClassName.substring(0,1).toUpperCase()+actionClassName.substring(1);
        return "com.baldurtech." + actionClassName + "Action";        
    }
}
