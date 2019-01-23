package org.thibaut.thelibrary.service.impl;

import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.Author;
import org.thibaut.thelibrary.domain.entity.Book;
import org.thibaut.thelibrary.service.contract.BookService;

import java.util.List;

@Component
public class BookServiceImpl extends AbstractService implements BookService {

	@Override
	public String getBookTitle( Integer id ){
		return getRepositoryFactory().getBookRepository().findById( id ).get().getTitle();
	}

	@Override
	public Book getBookById( Integer id ){
		return getRepositoryFactory().getBookRepository().findById( id ).get();
	}


	public List<Book> getBookByTitle( String title, String authorLastName, String authorFirstName, String style){

		List< Author > authors = getRepositoryFactory().getAuthorRepository().getAuthorsByLastNameAndFirstName( authorLastName,  authorFirstName  );

//		return getRepositoryFactory().getBookRepository().getBooksByTitleContainsAndAuthorsContainsAndStylesContains( title,  authors,  );
		return null;
	}
}
