package org.thibaut.thelibrary.webservice.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://thelibrary.service.ws/", name = "SearchBook")
public interface SearchBookWebService {

		@WebResult(name = "return", targetNamespace = "")
		@RequestWrapper(localName = "getBookTitle",
				targetNamespace = "http://thelibrary.service.ws/",
				className = "com.thibaut.thelibrary.webservice.webservice.BookTitle")
		@WebMethod(action = "urn:BookTitle")
		@ResponseWrapper(localName = "getBookTitleResponse",
				targetNamespace = "http://thelibrary.service.ws/",
				className = "com.thibaut.thelibrary.webservice.webservice.BookTitleResponse")
		String getBookTitle( @WebParam(name = "id", targetNamespace = "") Integer id );

	}