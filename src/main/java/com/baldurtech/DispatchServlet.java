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
            return null;
    }
}
