package org.thibaut.thelibrary.webservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thibaut.thelibrary.repository.contract.RepositoryFactory;
import org.thibaut.thelibrary.repository.repository.BookRepository;
import org.thibaut.thelibrary.repository.repository.RepositoryFactoryImpl;

@Configuration
public class ConfigTest {

	@Bean
	public RepositoryFactory repositoryFactory(){
		return new RepositoryFactoryImpl( ) ;
	}



}
