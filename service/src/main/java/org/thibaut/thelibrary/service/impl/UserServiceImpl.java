package org.thibaut.thelibrary.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.UserEntity;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
import org.thibaut.thelibrary.repository.repository.UserRepository;
import org.thibaut.thelibrary.service.contract.UserService;

import javax.persistence.EntityManager;

@Component
public class UserServiceImpl extends AbstractService implements UserService {


	public UserServiceImpl(
			RepositoryFactory repositoryFactory,
			UserRepository userRepository,
			EntityManager em ) {
		super( repositoryFactory, userRepository, em );
	}

	@Override
	public UserEntity findByUserName( String username ) {
		UserEntity userEntity = null;
		try {
			userEntity = getRepositoryFactory( ).getUserRepository( ).findByUserName( username );
//			userEntity.setRoles( getRepositoryFactory().getRoleRepository().findRoleByUserName( userEntity.getUserName() ) );
			userEntity.setRoles( getUserRepository( ).getRolesByUsername( username ) );
		} catch ( Exception e ) {
			throw e;
		}
		return userEntity;
	}


	@Override
	public UserEntity findByEmail( String email ) {
		UserEntity userEntity = null;
		try {
			userEntity = getRepositoryFactory( ).getUserRepository( ).findByEmail( email );
//			userEntity.setRoles( getRepositoryFactory().getRoleRepository().findRoleByEmail( email ) );
			userEntity.setRoles( getUserRepository( ).getRolesByEmail( email ) );

		} catch ( Exception e ) {
			throw e;
		}
		return userEntity;
	}
}
