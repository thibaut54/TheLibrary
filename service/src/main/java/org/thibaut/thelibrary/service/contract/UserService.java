package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.domain.entity.User;

public interface UserService {

	User findByUserName( String username );

	User findByEmail( String email );
}
