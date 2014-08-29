package com.baldurtech;

import java.util.Map;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DispatchServlet extends HttpServlet{
    public void service(HttpServletRequest request,HttpServletResponse response) 
        throws IOException,ServletException{        
        
        try{
            String uri = getUri(request);
            ActionContext actionContext = new ActionContextImpl(getServletContext(),request,response);
            Class actionClass = getActionByUri(uri);
            @SuppressWarnings("unchecked")
            Constructor actionConstructor = actionClass.getDeclaredConstructor(ActionContext.class);
            Action actionInstance = (Action) actionConstructor.newInstance(actionContext);
            @SuppressWarnings("unchecked")
            Method method = actionClass.getDeclaredMethod(getActionMethodNameByUri(uri));
            Object returnValue = method.invoke(actionInstance);
            if(null == returnValue){
                return;
            }

            if(returnValue instanceof Map){
                @SuppressWarnings("unchecked")
                Map<String, Object> dataModel = (Map<String, Object>)returnValue;
                for(String key: dataModel.keySet()){
                    request.setAttribute(key, dataModel.get(key));
                }
            }else{
                request.setAttribute("data",returnValue);
            }
            getServletContext()
                .getRequestDispatcher(getViewPage(uri))
                .forward(request,response);
        }catch(Exception e){

        }
    }    
     
    public String defaultPackageName = "com.baldurtech";
    public String defaultSuffix = ".jsp";

    public String getUri(HttpServletRequest request){
        return request.getRequestURI().replace(request.getContextPath(),"");
    }

    public Class getActionByUri(String uri) throws Exception{
        return Class.forName(getActionClassNameByUri(uri));
    }    
    
    public String getViewPage(String uri){
        return "/WEB-INF/jsp" + uri;
    }

    public String getActionClassNameByUri(String uri){
        int indexOfActionClassName = 1;
        String[] uriParts = splitBySlash(uri);       
        String actionClassName = capitalize(removeDefaultSuffix(uriParts[indexOfActionClassName]));
        return defaultPackageName + "." + actionClassName + "Action";  
          
    }
    public String getActionMethodNameByUri(String uri){
        int indexOfActionMethodName = 2;
        String[] uriParts = splitBySlash(uri);
        if(uriParts.length<=indexOfActionMethodName){
            return "index";
        }else{
            return removeDefaultSuffix(uriParts[indexOfActionMethodName]);
        }               
    }
    public String capitalize(String actionClassName){
        return actionClassName.substring(0,1).toUpperCase()+actionClassName.substring(1);
    }
    public String[] splitBySlash(String uri){
        return uri.split("/");
    }
    public String removeDefaultSuffix(String str){
        return str.replace(defaultSuffix,"");
    }    

}
