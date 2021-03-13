package com.scp.spring.mvc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

//componenet repository controller service

@Configuration  //it represetns this bean configurations -- bean.xml
@EnableWebMvc
@ComponentScan({ "com.scp.*" })//this represents base packageToScan <context:component-scan base-package="com.clc.*">
@PropertySource(value = { "classpath:database.properties" })//propertyplaceholder bean //<context:property-placeholder location="classpath:db.properties,app.properties" />
public class WebSpringBeanJavaConfig {

	@Value("${jdbc.driverClassName}")String driverClassName;
	@Value("${jdbc.url}")String dbUrl;
	@Value("${jdbc.username}")String dbUserName;
	@Value("${jdbc.password}")String password;
	
	@Value("${hibernate.dialect.property}")String hbmDialectProperty;
	@Value("${hibernate.dialect.value}")String hbmDialectPropertyValue;
	
	@Value("${hibernate.show_sql.property}")String hbmShowSqlProperty;
    @Value("${hibernate.show_sql.value}")String hbmShowSqlPropertyValue;
    
    @Value("${hibernate.format_sql.property}")String hbmFormatSqlProperty;
    @Value("${hibernate.format_sql.value}")String hbmFormatSqlPropertyValue;
    
    @Value("${hibernate.hbm2ddl.auto.property}")String hbmDdlAutoProperty;
    @Value("${hibernate.ddl.value}")String hbmDdlAutoPropertyValue;

    private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
    
    static{
    	System.out.println("spring bean configuration");
    }

    @Bean  //create object with new -- to spring container madhe add kara -- LocalsessionFactory
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.scp.spring.mvc.entities" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
    
    @Bean  //create object with new -- to spring container madhe add kara -- BasicDataSource
    public DataSource dataSource() {
    	
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(password);
        return dataSource;
    }
    

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(hbmDialectProperty,  hbmDialectPropertyValue);
        properties.put(hbmShowSqlProperty,hbmShowSqlPropertyValue);
        properties.put(hbmFormatSqlProperty,hbmFormatSqlPropertyValue);
        properties.put(hbmDdlAutoProperty,hbmDdlAutoPropertyValue);
        return properties;        
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/"); //emp
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        cmr.setMaxUploadSize(maxUploadSizeInMb * 2);
        cmr.setMaxUploadSizePerFile(maxUploadSizeInMb); //bytes
        return cmr;

    }
    
	
}
