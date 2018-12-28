package org.thibaut.thelibrary.webservice.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
import org.thibaut.thelibrary.repository.repository.BookRepository;
import org.thibaut.thelibrary.service.contract.ManagerFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@Slf4j
@WebService(serviceName = "SearchBookService", portName = "SearchBookPort",
		targetNamespace = "http://thelibrary.service.ws/",
		endpointInterface = "org.thibaut.thelibrary.webservice.webservice.SearchBookWebService" )
public class SearchBookWebServiceImpl extends AbstractWebService implements SearchBookWebService{

	@Override
	@WebMethod
	public String getBookTitle( Integer id ){
		return getManagerFactory().getBookManager().getBookTitle( id );
	}
}

//@Service
//@WebService(serviceName = "SearchBook")
//public class SearchBookWebServiceImpl {
//
//	private ManagerFactory managerFactory;
//
//	public ManagerFactory getManagerFactory( ) {
//		return managerFactory;
//	}
//
//	@Autowired
//	public void setManagerFactory( ManagerFactory managerFactory ) {
//		this.managerFactory = managerFactory;
//	}
//
//	@WebMethod
//	public String getBookTitle( Integer id ){
//
//		return getManagerFactory().getBookManager().getBookTitle( id );
//
//
//	}
//}
