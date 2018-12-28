package org.thibaut.thelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.service.contract.BookManager;
import org.thibaut.thelibrary.service.contract.ManagerFactory;

@Component
public class ManagerFactoryImpl implements ManagerFactory {

	private BookManager bookManager;

	@Override
	public BookManager getBookManager( ) {
		return bookManager;
	}

	@Override
	@Autowired
	public void setBookManager( BookManager bookManager ) {
		this.bookManager = bookManager;
	}
}
