package org.thibaut.thelibrary.webservice.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.CoordinatesDtoJaxb;
import org.thibaut.thelibrary.domain.entity.CoordinatesEntity;
import org.thibaut.thelibrary.webservice.util.ClassUtils;

@Component
@Slf4j
public class CoordinatesEntityToDto implements SuperConverter< CoordinatesEntity, CoordinatesDtoJaxb >{
	/**
	 * Applies this function to the given argument.
	 *
	 * @param coordinatesEntity the function argument
	 * @return the function result
	 */
	@Override
	public CoordinatesDtoJaxb apply( CoordinatesEntity coordinatesEntity ) {
		final CoordinatesDtoJaxb coordinatesDto = new CoordinatesDtoJaxb();
		ClassUtils.setIfNotNull( coordinatesEntity::getId, id -> coordinatesDto.setId( ( Long ) id ) );
		ClassUtils.setIfNotNull( coordinatesEntity::getEmail, email -> coordinatesDto.setEmail( ( String ) email ) );
		ClassUtils.setIfNotNull( coordinatesEntity::getStreet, street -> coordinatesDto.setStreet( ( String ) street ) );
		ClassUtils.setIfNotNull( coordinatesEntity::getStreetNumber, streetNumber -> coordinatesDto.setStreetNumber( ( String ) streetNumber ) );
		ClassUtils.setIfNotNull( coordinatesEntity::getAdditionalInformation, additionalInformation -> coordinatesDto.setAdditionalInformation( ( String ) additionalInformation ) );
		ClassUtils.setIfNotNull( coordinatesEntity::getCity, city -> coordinatesDto.setCity((String) city));
		ClassUtils.setIfNotNull( coordinatesEntity::getPostalCode, postalCode -> coordinatesDto.setPostalCode( (Long) postalCode) );
		ClassUtils.setIfNotNull( coordinatesEntity::getPhone, phone -> coordinatesDto.setPhone( ( String ) phone ));
		return coordinatesDto;
	}
}
