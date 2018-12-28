package org.thibaut.thelibrary.service.contract;

public interface ManagerFactory {

	BookManager getBookManager( );

	void setBookManager( BookManager bookManager );
}
