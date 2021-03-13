package com.scp.spring.mvc.main;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;



import com.scp.spring.mvc.config.WebSpringBeanJavaConfig;

public class TestSpringHibernateIntegration {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(WebSpringBeanJavaConfig.class);
		SessionFactory sfactory = (SessionFactory)context.getBean("sfactory");
		System.out.println(sfactory);
	}
	
}
