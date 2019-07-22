package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.domain.entity.UserEntity;

public interface UserService {

	UserEntity findByUserName( String username );

	UserEntity findByEmail( String email );
}
