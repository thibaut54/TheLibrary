package org.thibaut.thelibrary.webservice.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.service.contract.ServiceFactory;

@Service
//@Component
public abstract class AbstractWebService {

	private ServiceFactory serviceFactory;

	ServiceFactory getServiceFactory( ) {
		return serviceFactory;
	}

	@Autowired
	public void setServiceFactory( ServiceFactory serviceFactory ) {
		this.serviceFactory = serviceFactory;
	}


}
