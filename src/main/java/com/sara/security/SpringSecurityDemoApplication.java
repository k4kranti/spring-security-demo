package com.sara.security;

import com.sara.security.config.AuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.Collections;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<?> getFilterRegistrationBean(){
		FilterRegistrationBean<AuthenticationFilter> filterBean = new FilterRegistrationBean<>();
		filterBean.setFilter(new AuthenticationFilter());
		filterBean.setUrlPatterns(Collections.singletonList("/secure/admin"));
		filterBean.setOrder(2);
		return filterBean;
	}
}
