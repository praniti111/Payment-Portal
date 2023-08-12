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

public class LogFilter implements Filter {

   	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("REQUEST IS GENERATED FROM " + request.getRemoteAddr() );
		System.out.println("REQUEST IS GENERATED AT " + new Date().toString());
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		
	}
	
	public LogFilter() {
        
    }

	

}
