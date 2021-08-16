package com.sameer.SpringMVC_Hibernate_Image_Database.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sameer.SpringMVC_Hibernate_Image_Database.dao.FlowerDao;
import com.sameer.SpringMVC_Hibernate_Image_Database.dao.FlowerDaoImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sameer.SpringMVC_Hibernate_Image_Database.controller", "com.sameer.SpringMVC_Hibernate_Image_Database.dao" })
public class WebMvcConfig {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");

		return vr;
	}


	@Bean
	public FlowerDao getFlowerDao() {
		return new FlowerDaoImpl();
	}
	//This code is used to deal with MultiPartFile type.
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}