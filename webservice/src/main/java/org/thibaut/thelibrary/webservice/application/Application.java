package org.thibaut.thelibrary.webservice.application;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.thibaut.thelibrary.webservice.webservice.SearchBookWebService;
import org.thibaut.thelibrary.webservice.webservice.SearchBookWebServiceImpl;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@ComponentScan(basePackages = {"org.thibaut.thelibrary"})
@EnableJpaRepositories(basePackages = {"org.thibaut.thelibrary"})
@EntityScan(basePackages = {"org.thibaut.thelibrary"})
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run( Application.class, args );

	}

//	@Bean
//	public ServletRegistrationBean dispatcherServlet() {
//		return new ServletRegistrationBean(new CXFServlet(), "/soap-api/*");
//	}
//
//	@Bean(name = Bus.DEFAULT_BUS_ID)
//	public SpringBus springBus() {
//		return new SpringBus();
//	}
//
//	@Bean
//	public SearchBookWebService searchBookWebService() {
//		return new SearchBookWebServiceImpl();
//	}
//
//	@Bean
//	public Endpoint endpoint() {
//		EndpointImpl endpoint = new EndpointImpl(springBus(), searchBookWebService());
//		endpoint.publish("/SearchBookWebService");
//		return endpoint;
//	}

	@Override
	protected SpringApplicationBuilder configure( SpringApplicationBuilder builder ) {
		return builder.sources( Application.class );
	}
}
