package org.thibaut.thelibrary.repository.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;

@Component
public class RepositoryFactoryImpl implements RepositoryFactory {


	private BookRepository bookRepository;

	@Override
	public BookRepository getBookRepository( ) {
		return bookRepository;
	}

	@Override
	@Autowired
	public void setBookRepository( BookRepository bookRepository ) {
		this.bookRepository = bookRepository;
	}
}
