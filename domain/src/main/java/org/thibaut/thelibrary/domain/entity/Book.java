package org.thibaut.thelibrary.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:31:51
 */
@Entity
@Table(name = "book")
@Getter
@Setter
@EqualsAndHashCode
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;

	private String language;
	private Integer isbn;
	private LocalDate publicationDate;
	private Integer numberOfPages;

	@ManyToMany(mappedBy = "books")
	private List< Author > author;

	@ManyToMany
	@JoinTable(
			name = "books_of_libraries",
			joinColumns = { @JoinColumn(name = "book_id") },
			inverseJoinColumns = { @JoinColumn(name = "library_id") } )
	private List<Library> libraries;

	@ManyToOne
	@JoinColumn(name = "editor_id")
	private Editor editor;

	@OneToMany(mappedBy = "book")
	private List<Loan> loans;


}//end Book