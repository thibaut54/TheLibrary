package org.thibaut.thelibrary.webservice.endpoint;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.thibaut.thelibrary.domain.entity.Book;
import org.thibaut.thelibrary.domain.generated.jax2b.GetBookRequest;
import org.thibaut.thelibrary.domain.generated.jax2b.GetBookResponse;
import org.thibaut.thelibrary.service.contract.ServiceFactory;

import java.lang.reflect.Type;
import java.util.List;

@Endpoint
public class BookEndpoint {

	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ServiceFactory serviceFactory;

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public BookEndpoint(ServiceFactory serviceFactory) {

		this.serviceFactory = serviceFactory;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
	@ResponsePayload
	public GetBookResponse getBook( @RequestPayload GetBookRequest request) {

		Type listType = new TypeToken<List< Book >>(){}.getType();

		GetBookResponse response = new GetBookResponse();

		List<Book> bookListEntity = serviceFactory.getBookService().getBookByTitle( ( request.getBookTitle() ));

		List< org.thibaut.thelibrary.domain.generated.jax2b.Book > bookListResponse = modelMapper.map( bookListEntity, listType );

		response.getBook().addAll( bookListResponse );

		return response;
	}
}
