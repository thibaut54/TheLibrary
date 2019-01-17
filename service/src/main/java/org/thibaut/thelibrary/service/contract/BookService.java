package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.domain.entity.Book;

public interface BookService {
	String getBookTitle( Integer id );

	Book getBookById( Integer id );
}
