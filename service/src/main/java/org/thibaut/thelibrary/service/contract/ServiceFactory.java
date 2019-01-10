package org.thibaut.thelibrary.service.contract;

public interface ServiceFactory {

	BookService getBookService( );

	void setBookService( BookService bookService );
}
