package com.springwebconfig.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer {
	
	private static AnnotationConfigWebApplicationContext ctx = null;

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		ctx = new AnnotationConfigWebApplicationContext();
		
		ctx.register(SpringConfig.class);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		
		ctx.close();
		
	}

}
