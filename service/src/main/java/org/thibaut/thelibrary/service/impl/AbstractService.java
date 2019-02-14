package org.thibaut.thelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;

import javax.persistence.EntityManager;

@Component
public abstract class AbstractService {

	private RepositoryFactory repositoryFactory;

	private EntityManager em;

	RepositoryFactory getRepositoryFactory( ) {
		return repositoryFactory;
	}

	@Autowired
	public void setRepositoryFactory( RepositoryFactory repositoryFactory ) {
		this.repositoryFactory = repositoryFactory;
	}

	public EntityManager getEm( ) {
		return em;
	}

	@Autowired
	public void setEm( EntityManager em ) {
		this.em = em;
	}
}
