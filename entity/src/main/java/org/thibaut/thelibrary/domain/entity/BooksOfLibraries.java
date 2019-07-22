package org.thibaut.thelibrary.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:49:26
 */
@Entity
@Table(name = "books_of_libraries")
@Getter
@Setter
@EqualsAndHashCode
public class BooksOfLibraries {

	@EmbeddedId
	private BookLibraryId id;

	@ManyToOne
	@MapsId("bookId")
	private BookEntity book;

	@ManyToOne
	@MapsId("libraryId")
	private LibraryEntity library;

	private Integer stock;
}
