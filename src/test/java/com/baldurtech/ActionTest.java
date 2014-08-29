package com.baldurtech;

import com.baldurtech.unit.TestCase;

public class ActionTest extends TestCase{
    public void test_uri_contact_show_的页面显示应该是_jsp_contact_show(){
        Action action = new ContactAction();
        assertEquals("/WEB-INF/jsp/contact/show.jsp",action.getViewPage("/contact/show.jsp"));
    }
}
