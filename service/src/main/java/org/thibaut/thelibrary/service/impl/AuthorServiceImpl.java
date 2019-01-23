package org.thibaut.thelibrary.service.impl;

import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.Author;
import org.thibaut.thelibrary.service.contract.AuthorService;

import java.util.List;

@Component
public class AuthorServiceImpl extends AbstractService implements AuthorService {

	@Override
	public List< Author > getAuthorByLastNameAndFirstName( String lastName, String firstName ){
		return getRepositoryFactory().getAuthorRepository().getAuthorsByLastNameAndFirstName( lastName, firstName );
	}
}