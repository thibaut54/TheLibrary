package org.thibaut.thelibrary.repository.contract;

import org.thibaut.thelibrary.repository.repository.AuthorRepository;
import org.thibaut.thelibrary.repository.repository.BookRepository;
import org.thibaut.thelibrary.repository.repository.StyleRepository;

public interface RepositoryFactory {

	BookRepository getBookRepository( );

	void setBookRepository( BookRepository bookRepository );

	AuthorRepository getAuthorRepository( );

	void setAuthorRepository( AuthorRepository authorRepository );

	StyleRepository getStyleRepository( );

	void setStyleRepository( StyleRepository styleRepository );
}
