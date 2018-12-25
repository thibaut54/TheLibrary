package org.thibaut.thelibrary.webservice.webservice;

import org.thibaut.thelibrary.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;

import javax.jws.WebService;

@Slf4j
@WebService(serviceName = "SearchBookService", portName = "SearchBookPort",
		targetNamespace = "http://thelibrary.service.ws/",
		endpointInterface = "org.thibaut.thelibrary.webservice.webservice.SearchBookWebService" )
public class SearchBookWebServiceImpl implements SearchBookWebService{

	private BookRepository bookRepository;

	@Override
	public String getBookTitle( Integer id ){
		try {
			return "The title of the book with id = " + id + " is " + this.bookRepository.findById( id ).get().getTitle();
		}catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
