package org.thibaut.thelibrary.service.impl;

import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.Author;
import org.thibaut.thelibrary.domain.entity.QAuthor;
import org.thibaut.thelibrary.service.contract.AuthorService;

import java.util.List;

@Component
public class AuthorServiceImpl extends AbstractService implements AuthorService {

	@Override
	public List< Author > getAuthorByLastNameAndFirstName( String lastName, String firstName ){

		return getRepositoryFactory().getAuthorRepository().getAuthorsByFirstNameAndLastName( firstName, lastName );
	}


	public Author findAuthorByFirstNameAndLastName( Pageable pageable, String firstName, String lastName ){

		/*int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;

		QAuthor qAuthor = QAuthor.author;

		BooleanBuilder booleanBuilder = new BooleanBuilder();

		if( ! firstName.equals( "" )){
			booleanBuilder
					.and( qAuthor.firstName.containsIgnoreCase( firstName ) )
					.or( qAuthor.lastName.containsIgnoreCase( firstName) );
		}
		if( ! lastName.equals( "" )){
			booleanBuilder
					.and( qAuthor.firstName.containsIgnoreCase( lastName ) )
					.or( qAuthor.lastName.containsIgnoreCase( lastName) );
		}*/
		return null;
	}
}