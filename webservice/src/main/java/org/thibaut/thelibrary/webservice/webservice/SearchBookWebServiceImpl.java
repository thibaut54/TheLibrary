package org.thibaut.thelibrary.webservice.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
import org.thibaut.thelibrary.repository.repository.BookRepository;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@Slf4j
@WebService(serviceName = "SearchBookService", portName = "SearchBookPort",
		targetNamespace = "http://thelibrary.service.ws/",
		endpointInterface = "org.thibaut.thelibrary.webservice.webservice.SearchBookWebService" )
public class SearchBookWebServiceImpl implements SearchBookWebService{

	@Autowired
	private RepositoryFactory repositoryFactory;


	@WebMethod
	public String getBookTitle( Integer id ){
		try {
			return repositoryFactory.getBookRepository().findById( id ).get().getTitle();
		}catch (java.lang.Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
