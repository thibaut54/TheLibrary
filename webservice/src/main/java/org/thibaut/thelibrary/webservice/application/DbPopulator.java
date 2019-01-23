package org.thibaut.thelibrary.webservice.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thibaut.thelibrary.domain.entity.*;
import org.thibaut.thelibrary.repository.repository.*;
import org.thibaut.thelibrary.service.contract.PasswordService;
import org.thibaut.thelibrary.webservice.util.GenericBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbPopulator implements CommandLineRunner {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordService passwordService;
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private BooksOfLibrariesRepository booksOfLibrariesRepository;
	private CoordinatesRepository coordinatesRepository;
	private EditorRepository editorRepository;
	private LibraryRepository libraryRepository;
	private LoanRepository loanRepository;


	public DbPopulator( UserRepository userRepository, RoleRepository roleRepository, PasswordService passwordService, AuthorRepository authorRepository, BookRepository bookRepository, BooksOfLibrariesRepository booksOfLibrariesRepository, CoordinatesRepository coordinatesRepository, EditorRepository editorRepository, LibraryRepository libraryRepository, LoanRepository loanRepository ) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordService = passwordService;
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.booksOfLibrariesRepository = booksOfLibrariesRepository;
		this.coordinatesRepository = coordinatesRepository;
		this.editorRepository = editorRepository;
		this.libraryRepository = libraryRepository;
		this.loanRepository = loanRepository;
	}

	@Override
	public void run( String... args ) throws Exception {

		System.out.println( "CONSUMER APP RUN" );

		//-----CLEAN DB

		this.userRepository.deleteAll();
		this.coordinatesRepository.deleteAll();
		this.roleRepository.deleteAll();
		this.libraryRepository.deleteAll();
		this.bookRepository.deleteAll();
		this.booksOfLibrariesRepository.deleteAll();


		//-----POPULATE USER_ROLES

		List< Role > roles = new ArrayList<>();

		roles.add( GenericBuilder.of( Role::new )
							.with( Role::setRole, "ROLE_USER" )
							.build());

		this.roleRepository.saveAll( roles );


		//-----POPULATE USERS

		List< User > users = new ArrayList<>(  );

		//pwd = 1235
		users.add( GenericBuilder.of( User::new )
							.with(User::setFirstName, "John")
							.with(User::setLastName, "Doe")
							.with(User::setUserName, "TheJohn")
							.with(User::setPassword, passwordService.crypt( "1235"))
				           .with(User::setRegistrationDate, LocalDate.now())
				           .build());


		//-----SET ROLE

		List< Role > rolesUser1 = new ArrayList<>();
		rolesUser1.add( this.roleRepository.findByRoleLike( "%USER" ) );

		users.get( 0 ).setRoles( rolesUser1 );


		//-----POPULATE COORDINATES OF USERS

		List< Coordinates > coordinatesUsers = new ArrayList<>();
		coordinatesUsers.add( GenericBuilder.of( Coordinates::new )
									.with( Coordinates::setEmail, "john@gmail.com" )
									.build());

		users.get( 0 ).setCoordinates( coordinatesUsers.get( 0 ) );

		this.coordinatesRepository.saveAll( coordinatesUsers );


		//-----SAVE ALL USERS

		this.userRepository.saveAll( users );


		//-----POPULATE LIBRARIES

		List< Library > libraries = new ArrayList<>();

		libraries.add( GenericBuilder.of( Library::new )
								.with( Library::setName, "Library1" )
								.build());
		libraries.add( GenericBuilder.of( Library::new )
				               .with( Library::setName, "Library2" )
				               .build());

		this.libraryRepository.saveAll( libraries );


		//-----POPULATE COORDINATES OF LIBRARIES

		List< Coordinates > coordinatesLibraries = new ArrayList<>();
		coordinatesLibraries.add( GenericBuilder.of( Coordinates::new )
				                      .with( Coordinates::setEmail, "librariry1@gmail.com" )
				                      .build());
		coordinatesLibraries.add( GenericBuilder.of( Coordinates::new )
				                          .with( Coordinates::setEmail, "librariry2@gmail.com" )
				                          .build());

		libraries.get( 0 ).setCoordinates( coordinatesLibraries.get( 0 ) );
		libraries.get( 1 ).setCoordinates( coordinatesLibraries.get( 1 ) );

		this.coordinatesRepository.saveAll( coordinatesLibraries );


		//-----POPULATE BOOKS

		List< Book > booksLibrary1 = new ArrayList<>();
		booksLibrary1.add( GenericBuilder.of(Book::new)
									.with( Book::setTitle, "Book1" )
				                   .with( Book::setNumberOfPages, 145 )
				                   .with( Book::setLanguage, "English")
									.with( Book::setLibraries, libraries )
									.build());

		this.bookRepository.saveAll( booksLibrary1 );


		//-----SET STOCK OF BOOKS
		BookLibraryId bookLibraryId = new BookLibraryId(1,1);

		List<BooksOfLibraries> booksOfLibraries = booksOfLibrariesRepository.findAll();
		booksOfLibraries.get( 0 ).setStock( 5 );
		this.booksOfLibrariesRepository.saveAll( booksOfLibraries );
	}
}
