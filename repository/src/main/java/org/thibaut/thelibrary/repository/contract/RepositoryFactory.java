package org.thibaut.thelibrary.repository.contract;

import org.thibaut.thelibrary.repository.repository.BookRepository;

public interface RepositoryFactory {

	BookRepository getBookRepository( );

	void setBookRepository( BookRepository bookRepository );
}
