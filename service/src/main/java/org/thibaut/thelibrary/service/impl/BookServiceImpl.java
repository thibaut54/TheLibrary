package org.thibaut.thelibrary.service.impl;

import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.service.contract.BookService;

@Component
public class BookServiceImpl extends AbstractService implements BookService {

	@Override
	public String getBookTitle( Integer id ){
		return getRepositoryFactory().getBookRepository().findById( id ).get().getTitle();
	}
}
