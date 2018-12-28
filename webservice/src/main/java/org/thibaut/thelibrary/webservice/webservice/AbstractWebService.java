package org.thibaut.thelibrary.webservice.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.service.contract.ManagerFactory;

@Controller
public abstract class AbstractWebService {

	@Autowired
	private ManagerFactory managerFactory;

	ManagerFactory getManagerFactory( ) {
		return managerFactory;
	}

	public void setManagerFactory( ManagerFactory managerFactory ) {
		this.managerFactory = managerFactory;
	}
}
