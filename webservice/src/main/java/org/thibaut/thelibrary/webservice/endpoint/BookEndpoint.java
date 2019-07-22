package org.thibaut.thelibrary.webservice.endpoint;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.thibaut.thelibrary.BookDtoJaxb;
import org.thibaut.thelibrary.GetBookRequest;
import org.thibaut.thelibrary.GetBookResponse;
import org.thibaut.thelibrary.domain.entity.BookEntity;
import org.thibaut.thelibrary.service.contract.ServiceFactory;
import org.thibaut.thelibrary.webservice.constant.SoapProperties;

import java.lang.reflect.Type;
import java.util.List;

@Endpoint
public class BookEndpoint {

	private ServiceFactory serviceFactory;

	private ModelMapper modelMapper = new ModelMapper();

	@Autowired
	public BookEndpoint(ServiceFactory serviceFactory) {

		this.serviceFactory = serviceFactory;
	}

	@PayloadRoot(namespace = SoapProperties.TARGET_NAME_SPACE, localPart = "getBookRequest")
	@ResponsePayload
	public GetBookResponse getBook( @RequestPayload GetBookRequest request) {

		Type listType = new TypeToken<List< BookEntity >>(){}.getType();

		GetBookResponse response = new GetBookResponse();

		List< BookEntity > bookListEntity = serviceFactory.getBookService().getBookByTitle( ( request.getBookTitle() ));

		List< BookDtoJaxb > bookListResponse = modelMapper.map( bookListEntity, listType );

		response.getBook().addAll( bookListResponse );

		return response;
	}
}
