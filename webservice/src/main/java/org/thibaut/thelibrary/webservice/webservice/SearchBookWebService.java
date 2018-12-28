package org.thibaut.thelibrary.webservice.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://thelibrary.service.ws/", name = "SearchBook")
public interface SearchBookWebService {

	@WebMethod
	abstract String getBookTitle( Integer id );

	}