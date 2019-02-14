package org.thibaut.thelibrary.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:31:51
 */
@Entity
@Table(name = "authors")
@Getter
@Setter
@EqualsAndHashCode
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;
	private String lastName;
	private String nationality;

	@ManyToMany
	@JoinTable(
			name = "authors_of_books",
			joinColumns = { @JoinColumn(name = "author_id") },
			inverseJoinColumns = { @JoinColumn(name = "book_id") } )
	private List<Book> books;

}//end Author