//package org.thibaut.thelibrary.webservice.configuration;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//import org.thibaut.thelibrary.service.contract.ServiceFactory;
//import org.thibaut.thelibrary.service.impl.ManagerFactoryImpl;
//
//import javax.sql.DataSource;
//
////@PropertySource("classpath:application.properties")
////@ComponentScan(basePackages = "org.thibaut.thelibrary")
//@Configuration
//public class SpringApplicationContext {
//
//	@Bean
//	public ServiceFactory managerFactory(){
//		return new ManagerFactoryImpl();
//	}
//
//}