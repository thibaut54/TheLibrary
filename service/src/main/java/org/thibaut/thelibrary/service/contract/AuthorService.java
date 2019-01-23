package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.domain.entity.Author;

import java.util.List;

public interface AuthorService {

	List< Author > getAuthorByLastNameAndFirstName( String lastName, String firstName );
}
