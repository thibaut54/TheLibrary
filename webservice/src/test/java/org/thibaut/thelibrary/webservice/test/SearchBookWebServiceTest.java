package org.thibaut.thelibrary.webservice.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.thibaut.thelibrary.repository.BookRepository;
import org.thibaut.thelibrary.webservice.webservice.SearchBookWebService;
import org.thibaut.thelibrary.webservice.webservice.SearchBookWebServiceImpl;

import static junit.framework.TestCase.assertTrue;

@RunWith( SpringRunner.class)
public class SearchBookWebServiceTest {


	@TestConfiguration
	static class SearchBookWebServiceContextConfiguration{
		@Bean
		public SearchBookWebService searchBookWebService(){
			return new SearchBookWebServiceImpl();
		}
	}

	@Autowired
	SearchBookWebService searchBookWebService;

	@MockBean
	BookRepository bookRepository;

	public SearchBookWebServiceTest( ) {
	}


	@Test
	public void shouldAlwaysBeInvoked() {
		assertTrue("Should never fail and will ensure that the unit tests are possible to execute", true);
	}

	@Test
	public void checkFirstBookTitle(){

		String firstBookTitle = this.bookRepository.findAll().get( 0 ).getTitle();
		String firstBookTitleFromWS = this.searchBookWebService.getBookTitle( this.bookRepository.findAll().get( 0 ).getId() );

		assertTrue( firstBookTitle.equals( firstBookTitleFromWS ) );
	}
}
