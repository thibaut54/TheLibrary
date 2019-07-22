package org.thibaut.thelibrary.webservice.converter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.LoanDtoJaxb;
import org.thibaut.thelibrary.RoleDtoJaxb;
import org.thibaut.thelibrary.UserDtoJaxb;
import org.thibaut.thelibrary.domain.entity.CoordinatesEntity;
import org.thibaut.thelibrary.domain.entity.RoleEntity;
import org.thibaut.thelibrary.domain.entity.UserEntity;
import org.thibaut.thelibrary.webservice.util.ClassUtils;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class UserEntityToDto implements SuperConverter< UserEntity, UserDtoJaxb >{

	private final CoordinatesEntityToDto coordinatesEntityToDto;

	/**
	 * Applies this function to the given argument.
	 *
	 * @param userEntity the function argument
	 * @return the function result
	 */
	@Override
	public UserDtoJaxb apply( UserEntity userEntity ) {
		final UserDtoJaxb userDto = new UserDtoJaxb();
		ClassUtils.setIfNotNull( userEntity::getId, id -> userDto.setId( ( Long ) id ) );
		ClassUtils.setIfNotNull( userEntity::getPassword, password -> userDto.setPassword( ( String ) password ) );
		ClassUtils.setIfNotNull( userEntity::getFirstName, firstName -> userDto.setFirstName( ( String ) firstName ) );
		ClassUtils.setIfNotNull( userEntity::getLastName, lastName -> userDto.setLastName( ( String ) lastName ) );
		ClassUtils.setIfNotNull( userEntity::getUserName, userName -> userDto.setUserName( ( String ) userName ) );
		ClassUtils.setIfNotNull( userEntity::getRoles, roles -> userDto.getRoles().addAll( (List< RoleDtoJaxb >) roles ));
		ClassUtils.setIfNotNull(
				userEntity::getCoordinates,
				coordinates -> userDto.setCoordinates( coordinatesEntityToDto.apply( ( CoordinatesEntity ) coordinates ))
		);
		ClassUtils.setIfNotNull( userEntity::getLoans, loans -> userDto.getLoans().addAll ( ( List< LoanDtoJaxb > )  loans  ));
		return userDto;
	}
}
