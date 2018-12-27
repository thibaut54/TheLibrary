package org.thibaut.thelibrary.webservice.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.thibaut.thelibrary.repository.BookRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Slf4j
@WebService(serviceName = "SearchBookService", portName = "SearchBookPort",
		targetNamespace = "http://thelibrary.service.ws/",
		endpointInterface = "org.thibaut.thelibrary.webservice.webservice.SearchBookWebService" )
public class SearchBookWebServiceImpl implements SearchBookWebService{

	@Autowired
	private BookRepository bookRepository;


	@WebMethod
	public String getBookTitle( Integer id ){
		try {
			return "The title of the book with id = " + id + " is " + this.bookRepository.findById( id ).get().getTitle();
		}catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
