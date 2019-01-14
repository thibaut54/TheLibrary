package org.thibaut.thelibrary.webservice.webservice;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.thibaut.thelibrary.webservice.configuration.WebApplicationContextLocator;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@WebService(serviceName = "getBookTitle")
public class SearchBookService extends AbstractWebService implements generated.searchbookservice.SearchBookService {

	/**
	 * @param id
	 * @return returns java.lang.String
	 */
	@Override
	@WebMethod
	public String getBookTitle( Integer id ) {
		return getServiceFactory().getBookService().getBookTitle( id );
	}

	public SearchBookService() {
		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
		WebApplicationContext currentContext = WebApplicationContextLocator.getCurrentWebApplicationContext();
		bpp.setBeanFactory(currentContext.getAutowireCapableBeanFactory());
		bpp.processInjection(this);
	}

	// alternative constructor to facilitate unit testing.
	protected SearchBookService( ApplicationContext context) {
		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
		bpp.setBeanFactory(new DefaultListableBeanFactory(context));
		bpp.processInjection(this);
	}

}
