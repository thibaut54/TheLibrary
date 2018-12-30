package org.thibaut.thelibrary.webservice.webservice;

import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@WebService(serviceName = "testws")
public class TestWebService extends AbstractWebService{

	@WebMethod
	public String getBookTitle( Integer id ){
		return getServiceFactory().getBookService().getBookTitle( id );
	}

}
