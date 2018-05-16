package com.loginDemo.loginDemo;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=false)
@ComponentScan(basePackageClasses = UserRestController.class)
public class LoginDemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LoginDemoApplication.class, args);
		System.out.println("run....");
	}
	
	 @Bean
	    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	        return hemf.getSessionFactory();
	    }
		//changes for second branch
		//changes form 1st branch
		//changes form new branch ------------
}
