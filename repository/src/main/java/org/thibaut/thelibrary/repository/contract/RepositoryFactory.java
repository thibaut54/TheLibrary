package org.thibaut.thelibrary.repository.contract;

import org.thibaut.thelibrary.repository.repository.AuthorRepository;
import org.thibaut.thelibrary.repository.repository.BookRepository;
import org.thibaut.thelibrary.repository.repository.CategoryRepository;

public interface RepositoryFactory {

	BookRepository getBookRepository( );

	void setBookRepository( BookRepository bookRepository );

	AuthorRepository getAuthorRepository( );

	void setAuthorRepository( AuthorRepository authorRepository );

	CategoryRepository getCategoryRepository( );

	void setCategoryRepository( CategoryRepository categoryRepository );
}
