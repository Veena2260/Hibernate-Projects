package org.impelsys.config;

import java.util.Properties;

import javax.activation.DataSource;

//import javax.activation.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@Configuration
//@EnableTransactionManagement
//@ImportResource({"classpath:beans.xml"})
@ComponentScan(basePackages={"org.impelsys.controller","org.impelsys.data.model","org.impelsys.data","org.impelsys.service"})

public class HibernateXMLConf {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("org.impelsys.data.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test456");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	@Bean
	public PlatformTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager transactionManager=
				new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	private final Properties hibernateProperties(){
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");
		hibernateProperties.setProperty("hibernate.dialect",
				"org.hibernate.dialect.MySQL8Dialect");
		return hibernateProperties;
	}

}
