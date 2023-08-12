package com.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionPropertiesListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent e) {
        HttpSession session = e.getSession();
        session.setMaxInactiveInterval(60);
    }
	    
    public void sessionDestroyed(HttpSessionEvent e) {
        // TODO Auto-generated method stub
    }
	
}
