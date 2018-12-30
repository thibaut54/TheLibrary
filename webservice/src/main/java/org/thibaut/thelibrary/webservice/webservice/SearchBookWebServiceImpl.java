package org.thibaut.thelibrary.webservice.webservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;


@Service
@Slf4j
@WebService(serviceName = "SearchBookService", portName = "SearchBookPort",
		targetNamespace = "http://thelibrary.service.ws/",
		endpointInterface = "org.thibaut.thelibrary.webservice.webservice.SearchBookWebService")
public class SearchBookWebServiceImpl extends AbstractWebService implements SearchBookWebService{

	@Override
	@WebMethod
	public String getBookTitle( Integer id ){
		return getServiceFactory().getBookService().getBookTitle( id );
	}

}

//@Service
//@WebService(serviceName = "SearchBook")
//public class SearchBookWebServiceImpl {
//
//	private ServiceFactory managerFactory;
//
//	public ServiceFactory getServiceFactory( ) {
//		return managerFactory;
//	}
//
//	@Autowired
//	public void setServiceFactory( ServiceFactory managerFactory ) {
//		this.managerFactory = managerFactory;
//	}
//
//	@WebMethod
//	public String getBookTitle( Integer id ){
//
//		return getServiceFactory().getBookService().getBookTitle( id );
//
//
//	}
//}
