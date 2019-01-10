package org.thibaut.thelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.service.contract.BookService;
import org.thibaut.thelibrary.service.contract.ServiceFactory;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

	private BookService bookService;

	@Override
	public BookService getBookService( ) {
		return bookService;
	}

	@Override
	@Autowired
	public void setBookService( BookService bookService ) {
		this.bookService = bookService;
	}
}
