package org.thibaut.thelibrary.webservice.configuration;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thibaut.thelibrary.webservice.webservice.SearchBookWebServiceImpl;

@Configuration
public class WebServiceConfiguration {

	@Autowired
	private Bus bus;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new SearchBookWebServiceImpl());
		endpoint.publish("/SearchBookService");
		return endpoint;
	}
}
