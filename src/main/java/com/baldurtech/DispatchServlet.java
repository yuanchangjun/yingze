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
     
    public String defaultPackageName = "com.baldurtech";
    public String methodSuffix = ".jsp";

    public String getActionClassNameByUri(String uri){
        int indexOfActionClassName = 1;
        String[] uriParts = splitBySlash(uri);       
        String actionClassName = capitalize(removeMethodSuffix(uriParts[indexOfActionClassName]));
        return defaultPackageName + "." + actionClassName + "Action";  
          
    }
    public String getActionMethodNameByUri(String uri){
        int indexOfActionMethodName = 2;
        String[] uriParts = splitBySlash(uri);
        if(uriParts.length<=indexOfActionMethodName){
            return "index";
        }else{
            return removeMethodSuffix(uriParts[indexOfActionMethodName]);
        }               
    }
    public String capitalize(String actionClassName){
        return actionClassName.substring(0,1).toUpperCase()+actionClassName.substring(1);
    }
    public String[] splitBySlash(String uri){
        return uri.split("/");
    }
    public String removeMethodSuffix(String str){
        return str.replace(methodSuffix,"");
    }

}
