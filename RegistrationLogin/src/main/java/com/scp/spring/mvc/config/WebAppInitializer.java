package com.scp.spring.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//web.xml -- Web.xml -- 

/**
 * Servlet
 * 	class
 * 	name
 * 	init-param
 * 		param-name
 * 		param-value
 * 	load on startup
 * 
 * servlet-mapping
 * 	url
 * 	servlet name
 * 
 * context-param
 * 	param-name
 * 	param-value
 * 
 * 
 * 
 * @author Yogesh
 *
 */
public class WebAppInitializer implements WebApplicationInitializer {
 
    public void onStartup(ServletContext container) throws ServletException {
    	System.out.println("Loading...WebXml");
    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebSpringBeanJavaConfig.class);
        ctx.setServletContext(container);
        
        ServletRegistration.Dynamic servlet = container.addServlet("springmvc", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);  // it represents when to load the servlet.. dispatcherservlet
        servlet.addMapping("/");
        
    } 

 }