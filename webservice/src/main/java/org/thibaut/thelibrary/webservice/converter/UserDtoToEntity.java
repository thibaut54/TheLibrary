package org.thibaut.thelibrary.webservice.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.UserDtoJaxb;
import org.thibaut.thelibrary.domain.entity.CoordinatesEntity;
import org.thibaut.thelibrary.domain.entity.LoanEntity;
import org.thibaut.thelibrary.domain.entity.RoleEntity;
import org.thibaut.thelibrary.domain.entity.UserEntity;
import org.thibaut.thelibrary.webservice.util.ClassUtils;

import java.util.List;

@Component
@Slf4j
public class UserDtoToEntity implements SuperConverter< UserDtoJaxb, UserEntity > {


	/**
	 * Applies this function to the given argument.
	 *
	 * @param userDto the function argument
	 * @return the function result
	 */
	@Override
	public UserEntity apply( UserDtoJaxb userDto ) {
		final UserEntity userEntity = new UserEntity();
		ClassUtils.setIfNotNull( userDto::getId, id -> userEntity.setId( ( Long ) id ) );
		ClassUtils.setIfNotNull( userDto::getPassword, password -> userEntity.setPassword( ( String ) password ) );
		ClassUtils.setIfNotNull( userDto::getFirstName, firstName -> userEntity.setFirstName( ( String ) firstName ) );
		ClassUtils.setIfNotNull( userDto::getLastName, lastName -> userEntity.setLastName( ( String ) lastName ) );
		ClassUtils.setIfNotNull( userDto::getUserName, userName -> userEntity.setUserName( ( String ) userName ) );
			ClassUtils.setIfNotNull( userDto::getRoles, roles -> userEntity.setRoles( ( List< RoleEntity > ) roles ) );
		ClassUtils.setIfNotNull( userDto::getCoordinates, coordinates -> userEntity.setCoordinates( ( CoordinatesEntity ) coordinates ) );
		ClassUtils.setIfNotNull( userDto::getLoans, loans -> userEntity.setLoans( ( List< LoanEntity > ) loans ) );
		return userEntity;
	}

}
