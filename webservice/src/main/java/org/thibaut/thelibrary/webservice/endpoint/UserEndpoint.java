package org.thibaut.thelibrary.webservice.endpoint;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.thibaut.thelibrary.GetUserRequest;
import org.thibaut.thelibrary.GetUserResponse;
import org.thibaut.thelibrary.UserDtoJaxb;
import org.thibaut.thelibrary.domain.entity.RoleEntity;
import org.thibaut.thelibrary.domain.entity.UserEntity;
import org.thibaut.thelibrary.service.contract.ServiceFactory;
import org.thibaut.thelibrary.webservice.constant.SoapProperties;
import org.thibaut.thelibrary.webservice.converter.UserEntityToDto;

import javax.xml.bind.annotation.XmlSeeAlso;

@Endpoint
@Slf4j
@AllArgsConstructor
//@XmlSeeAlso( { RoleEntity.class } )
public class UserEndpoint {

	private final ServiceFactory serviceFactory;
	private final UserEntityToDto userEntityToDto;


	@PayloadRoot(namespace = SoapProperties.TARGET_NAME_SPACE, localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUser( @RequestPayload GetUserRequest request ){

		GetUserResponse response = new GetUserResponse();

		UserEntity userEntity = null;
		if ( request.getEmail() != null ) {
			userEntity = serviceFactory.getUserService().findByEmail( request.getEmail() );
		} else {
			userEntity = serviceFactory.getUserService().findByUserName( request.getUserName() );
		}

		UserDtoJaxb userDto = userEntityToDto.apply( userEntity );

		response.setUserDtoJaxb( userDto );

		log.info( "Authentication successful. UserEntity with email " + request.getEmail() + " is connected." );

		return response;
	}

}
