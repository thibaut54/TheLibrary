package org.thibaut.thelibrary.webservice.configuration;

import generated.searchbookservice.SearchBookService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.xml.ws.Endpoint;

@EnableWs
@Configuration
public class WebServiceConfiguration {

	@Autowired
	private SpringBus bus;


	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, SearchBookService.class);
		endpoint.publish("/SearchBookService");
		return endpoint;
	}


	@Bean
	public ServletRegistrationBean messageDispatcherServlet( ApplicationContext applicationContext )
	{
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/service/*");
	}
}
