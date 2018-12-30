//package org.thibaut.thelibrary.webservice.test;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
//import org.thibaut.thelibrary.webservice.application.Application;
//import org.thibaut.thelibrary.webservice.webservice.SearchBookWebService;
//
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertTrue;
//
//@RunWith( SpringRunner.class )
//@SpringBootTest(classes = Application.class)
//@Transactional
//public class SearchBookWebServiceTest {
//
//
//	@Autowired
//	SearchBookWebService searchBookWebService;
//
//	@Autowired
//	RepositoryFactory repositoryFactory;
//
//	public SearchBookWebServiceTest( ) {
//	}
//
//
//	@Test
//	public void shouldAlwaysBeInvoked() {
//		assertTrue("Should never fail and will ensure that the unit tests are possible to execute", true);
//	}
//
//	@Test
//	public void checkFirstBookTitle(){
//
//		String firstBookTitle = repositoryFactory.getBookRepository().findAll().get( 0 ).getTitle();
//		String firstBookTitleFromWS = searchBookWebService.getBookTitle( repositoryFactory.getBookRepository().findAll().get( 0 ).getId() );
//
//		assertEquals( firstBookTitle, firstBookTitleFromWS );
//	}
//}
