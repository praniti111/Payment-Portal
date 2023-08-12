package com.filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.tomcat.jni.Time;

public class PerformanceFilter implements Filter {

  
    public PerformanceFilter() {
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Date date1 = new Date();
		chain.doFilter(request, response);
		Date date2 = new Date();
		System.out.println("THE PERFORMANCE TIME IS " +(date2.getTime()-date1.getTime())+"MILLISECONDS" );
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
