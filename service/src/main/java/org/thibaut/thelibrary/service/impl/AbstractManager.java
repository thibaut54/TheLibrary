package org.thibaut.thelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;

@Component
public abstract class AbstractManager {

	private RepositoryFactory repositoryFactory;

	RepositoryFactory getRepositoryFactory( ) {
		return repositoryFactory;
	}

	@Autowired
	public void setRepositoryFactory( RepositoryFactory repositoryFactory ) {
		this.repositoryFactory = repositoryFactory;
	}
}
