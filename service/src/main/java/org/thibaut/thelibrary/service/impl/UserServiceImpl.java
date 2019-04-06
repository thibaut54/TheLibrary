package org.thibaut.thelibrary.service.impl;

import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.User;
import org.thibaut.thelibrary.service.contract.UserService;

@Component
public class UserServiceImpl extends AbstractService implements UserService {


	@Override
	public User findByUserName( String username){
		User user = null;
		try {
			user = getRepositoryFactory().getUserRepository().findByUserName(username);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}


	@Override
	public  User findByEmail( String email ){
		User user = null;
		try {
			user = getRepositoryFactory().getUserRepository().findByEmail(email);
		} catch (Exception e) {
			throw e;
		}
		return user;
	}
}
