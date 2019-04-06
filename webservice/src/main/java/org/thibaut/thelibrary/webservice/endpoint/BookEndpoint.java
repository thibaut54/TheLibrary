package org.thibaut.thelibrary.webservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.thibaut.thelibrary.domain.entity.Author;
import org.thibaut.thelibrary.service.contract.ServiceFactory;
import org.thibaut.thelibrary.webservice.generated.jaxb2.Book;
import org.thibaut.thelibrary.webservice.generated.jaxb2.GetBookRequest;
import org.thibaut.thelibrary.webservice.generated.jaxb2.GetBookResponse;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BookEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ServiceFactory serviceFactory;

	@Autowired
	public BookEndpoint(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
	@ResponsePayload
	public GetBookResponse getBook( @RequestPayload GetBookRequest request) {

		GetBookResponse response = new GetBookResponse();

		List<org.thibaut.thelibrary.domain.entity.Book> bookListDomain = serviceFactory.getBookService().getBookByTitle( ( request.getBookTitle() ));

		List< Author > authorsDomain = new ArrayList<>();

		for ( org.thibaut.thelibrary.domain.entity.Book bookDomain: bookListDomain ) {
			authorsDomain.addAll( bookDomain.getAuthors() );
		}

		List< org.thibaut.thelibrary.webservice.generated.jaxb2.Author > authorsResponse = new ArrayList<>();

		//FIXME mettre ça dans un mapper
		for ( Author authorDomain : authorsDomain ) {
			org.thibaut.thelibrary.webservice.generated.jaxb2.Author authorResponse = new org.thibaut.thelibrary.webservice.generated.jaxb2.Author();
			authorResponse.setId( authorDomain.getId() );
			authorResponse.setFirstName( authorDomain.getFirstName() );
			authorResponse.setLastName( authorDomain.getLastName() );
			authorResponse.setNationality( authorDomain.getNationality() );

			authorsResponse.add( authorResponse );
		}

		List< Book > bookListResponse = new ArrayList<>();

		for ( org.thibaut.thelibrary.domain.entity.Book bookDomain: bookListDomain ) {

			Book bookResponse = new Book();

			bookResponse.setId( bookDomain.getId() );
			bookResponse.getAuthors().addAll( authorsResponse );
			bookResponse.setTitle( bookDomain.getTitle() );
			bookResponse.setLanguage( bookDomain.getLanguage() );

			response.getBook().add( bookResponse );

		}

		return response;
	}
}
