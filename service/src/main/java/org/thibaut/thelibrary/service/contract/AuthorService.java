package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.domain.entity.AuthorEntity;

import java.util.List;

public interface AuthorService {

	List< AuthorEntity > getAuthorByLastNameAndFirstName( String lastName, String firstName );

}
