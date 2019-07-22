//package org.thibaut.thelibrary.webservice.application;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.thibaut.thelibrary.domain.entity.*;
//import org.thibaut.thelibrary.repository.repository.*;
//import org.thibaut.thelibrary.service.contract.PasswordService;
//import org.thibaut.thelibrary.webservice.util.GenericBuilder;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DbPopulator implements CommandLineRunner {
//
//	private UserRepository userRepository;
//	private RoleRepository roleRepository;
//	private PasswordService passwordService;
//	private AuthorRepository authorRepository;
//	private BookRepository bookRepository;
//	private BooksOfLibrariesRepository booksOfLibrariesRepository;
//	private CoordinatesRepository coordinatesRepository;
//	private EditorRepository editorRepository;
//	private LibraryRepository libraryRepository;
//	private LoanRepository loanRepository;
//	private CategoryRepository categoryRepository;
//
//
//	public DbPopulator( UserRepository userRepository, RoleRepository roleRepository, PasswordService passwordService, AuthorRepository authorRepository, BookRepository bookRepository, BooksOfLibrariesRepository booksOfLibrariesRepository, CoordinatesRepository coordinatesRepository, EditorRepository editorRepository, LibraryRepository libraryRepository, LoanRepository loanRepository, CategoryRepository categoryRepository ) {
//		this.userRepository = userRepository;
//		this.roleRepository = roleRepository;
//		this.passwordService = passwordService;
//		this.authorRepository = authorRepository;
//		this.bookRepository = bookRepository;
//		this.booksOfLibrariesRepository = booksOfLibrariesRepository;
//		this.coordinatesRepository = coordinatesRepository;
//		this.editorRepository = editorRepository;
//		this.libraryRepository = libraryRepository;
//		this.loanRepository = loanRepository;
//		this.categoryRepository= categoryRepository;
//	}
//
//	@Override
//	public void run( String... args ) throws Exception {
//
//		System.out.println( "CONSUMER APP RUN" );
//
//		//-----CLEAN DB
//
//		this.userRepository.deleteAll();
//		this.coordinatesRepository.deleteAll();
//		this.roleRepository.deleteAll();
//		this.libraryRepository.deleteAll();
//		this.bookRepository.deleteAll();
//		this.categoryRepository.deleteAll();
//		this.booksOfLibrariesRepository.deleteAll();
//
//
//		//-----POPULATE USER_ROLES
//
//		List< RoleEntity > roles = new ArrayList<>();
//
//		roles.add( GenericBuilder.of( RoleEntity::new )
//							.with( RoleEntity::setRole, "ROLE_USER" )
//							.build());
//
//		this.roleRepository.saveAll( roles );
//
//
//		//-----POPULATE USERS
//
//		List< UserEntity > userEntities = new ArrayList<>(  );
//
//		//pwd = 1235
//		userEntities.add( GenericBuilder.of( UserEntity::new )
//							.with(UserEntity::setFirstName, "John")
//							.with(UserEntity::setLastName, "Doe")
//							.with(UserEntity::setUserName, "TheJohn")
//							.with(UserEntity::setPassword, passwordService.crypt( "1235"))
//				           .with(UserEntity::setRegistrationDate, LocalDate.now())
//				           .build());
//
//
//		//-----SET ROLE
//
//		List< RoleEntity > rolesUser1 = new ArrayList<>();
//		rolesUser1.add( this.roleRepository.findByRoleLike( "%USER" ) );
//
//		userEntities.get( 0 ).setRoles( rolesUser1 );
//
//
//		//-----POPULATE COORDINATES OF USERS
//
//		List< CoordinatesEntity > coordinatesUsers = new ArrayList<>();
//		coordinatesUsers.add( GenericBuilder.of( CoordinatesEntity::new )
//									.with( CoordinatesEntity::setEmail, "john@gmail.com" )
//									.build());
//
//		userEntities.get( 0 ).setCoordinates( coordinatesUsers.get( 0 ) );
//
//		this.coordinatesRepository.saveAll( coordinatesUsers );
//
//
//		//-----SAVE ALL USERS
//
//		this.userRepository.saveAll( userEntities );
//
//
//		//-----POPULATE LIBRARIES
//
//		List< LibraryEntity > libraries = new ArrayList<>();
//
//		libraries.add( GenericBuilder.of( LibraryEntity::new )
//								.with( LibraryEntity::setName, "Library1" )
//								.build());
//		libraries.add( GenericBuilder.of( LibraryEntity::new )
//				               .with( LibraryEntity::setName, "Library2" )
//				               .build());
//
//		this.libraryRepository.saveAll( libraries );
//
//
//		//-----POPULATE COORDINATES OF LIBRARIES
//
//		List< CoordinatesEntity > coordinatesLibraries = new ArrayList<>();
//		coordinatesLibraries.add( GenericBuilder.of( CoordinatesEntity::new )
//				                      .with( CoordinatesEntity::setEmail, "librariry1@gmail.com" )
//				                      .build());
//		coordinatesLibraries.add( GenericBuilder.of( CoordinatesEntity::new )
//				                          .with( CoordinatesEntity::setEmail, "librariry2@gmail.com" )
//				                          .build());
//
//		libraries.get( 0 ).setCoordinates( coordinatesLibraries.get( 0 ) );
//		libraries.get( 1 ).setCoordinates( coordinatesLibraries.get( 1 ) );
//
//		this.coordinatesRepository.saveAll( coordinatesLibraries );
//
//
//		//-----POPULATE BOOKS
//
//		List< BookEntity > booksLibrary1 = new ArrayList<>();
//		booksLibrary1.add( GenericBuilder.of(BookEntity::new)
//									.with( BookEntity::setTitle, "Book1" )
//				                   .with( BookEntity::setNumberOfPages, 145 )
//				                   .with( BookEntity::setLanguage, "English")
//									.with( BookEntity::setLibraries, libraries )
//									.build());
//
//		this.bookRepository.saveAll( booksLibrary1 );
//
//		//-----POPULATE STYLE
//
//		List<CategoryEntity> styles = new ArrayList<>();
//		styles.add( GenericBuilder.of( CategoryEntity::new )
//						.with( CategoryEntity::setCategory, "CHILDREN" )
//						.build());
//		styles.add( GenericBuilder.of( CategoryEntity::new )
//				            .with( CategoryEntity::setCategory, "CULTURE" )
//				            .build());
//		styles.add( GenericBuilder.of( CategoryEntity::new )
//				            .with( CategoryEntity::setCategory, "EDUCATION" )
//				            .build());
//		styles.add( GenericBuilder.of( CategoryEntity::new )
//				            .with( CategoryEntity::setCategory, "FANTASY")
//				            .build());
//		styles.add( GenericBuilder.of( CategoryEntity::new )
//				            .with( CategoryEntity::setCategory, "LITERATURE&FICTION")
//				            .build());
//		this.categoryRepository.saveAll( styles );
//
//		//-----SET STYLE OF BOOK
//		List<CategoryEntity> stylesBook1 = new ArrayList<>();
//		stylesBook1.add( this.categoryRepository.findAll().get( 1 ) );
//		stylesBook1.add( this.categoryRepository.findAll().get( 2 ) );
//		BookEntity book = this.bookRepository.findAll().get( 0 );
//		book.setCategories( stylesBook1 );
//		this.bookRepository.save( book );
//
//
//		//-----SET STOCK OF BOOKS
//		BookLibraryId bookLibraryId = new BookLibraryId(1,1);
//
//		List<BooksOfLibraries> booksOfLibraries = booksOfLibrariesRepository.findAll();
//		booksOfLibraries.get( 0 ).setStock( 5 );
//		this.booksOfLibrariesRepository.saveAll( booksOfLibraries );
//
//	}
//}
