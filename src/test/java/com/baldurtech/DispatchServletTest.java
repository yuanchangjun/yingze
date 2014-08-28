package com.baldurtech;

import com.baldurtech.unit.TestCase;

public class DispatchServletTest extends TestCase{
    
    DispatchServlet dispatchServlet = new DispatchServlet();
    String actionClassName = "com.baldurtech.ContactAction";
    public void test_uri_contact_show_应该由ContactAction来处理(){       
        assertEquals(actionClassName,dispatchServlet.getActionClassNameByUri("/contact/show.jsp"));
    }

    public void test_uri_contact_应该由ContactAction来处理(){       
        assertEquals(actionClassName,dispatchServlet.getActionClassNameByUri("/contact.jsp"));
    }
    public void test_uri_contact_show_的处理方法是show(){
        assertEquals("show",dispatchServlet.getActionMethodNameByUri("/contact/show.jsp"));
    }
    public void test_uri_contact_的默认处理方法是index(){      
        assertEquals("index",dispatchServlet.getActionMethodNameByUri("/contact.jsp"));
    }
    public void test_uri_contact_show_的显示页面应该是_jsp_contact_show(){
        assertEquals("/WEB-INF/jsp/contact/show.jsp",dispatchServlet.getViewPage("/contact/show.jsp"));
    }
} 
