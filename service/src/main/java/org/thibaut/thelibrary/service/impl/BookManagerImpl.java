package org.thibaut.thelibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
import org.thibaut.thelibrary.service.contract.BookManager;

@Component
public class BookManagerImpl extends AbstractManager implements BookManager {

	@Override
	public String getBookTitle( Integer id ){
		return getRepositoryFactory().getBookRepository().findById( id ).get().getTitle();
	}
}
