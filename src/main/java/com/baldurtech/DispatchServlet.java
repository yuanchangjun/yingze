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
     
    String defaultPackageName = "com.baldurtech";

    public String getActionClassNameByUri(String uri){
        int indexOfActionClassName = 1;
        String[] uriParts = uri.split("/");       
        String actionClassName = capitalize(uriParts[indexOfActionClassName]);
        return defaultPackageName + "." + actionClassName + "Action";        
    }
    public String getActionMethodNameByUri(String uri){
        int indexOfActionMethodName = 2;
        String[] uriParts = uri.split("/");
        if(uriParts.length<=indexOfActionMethodName){
            return "index";
        }else{
            return uriParts[indexOfActionMethodName];
        }               
    }
    public String capitalize(String actionClassName){
       return actionClassName.substring(0,1).toUpperCase()+actionClassName.substring(1);
    }

}
