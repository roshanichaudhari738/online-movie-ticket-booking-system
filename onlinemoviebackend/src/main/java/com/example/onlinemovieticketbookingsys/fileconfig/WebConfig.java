package com.example.onlinemovieticketbookingsys.fileconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	public void addResourceHandlers(ResourceHandlerRegistry registery)
	{
		String uploadPath = System.getProperty("user.dir") + "/uploads/";
		registery.addResourceHandler("/images/**").addResourceLocations("file:"+uploadPath);
	}

}
