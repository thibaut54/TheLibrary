package org.thibaut.thelibrary.service.contract;

import org.thibaut.thelibrary.domain.entity.Book;

import java.util.List;

public interface BookService {
	String getBookTitle( Integer id );

	Book getBookById( Integer id );

	List<Book> getBookByTitle( String title );
}
