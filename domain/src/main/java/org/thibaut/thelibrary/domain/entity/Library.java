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
@Table(name = "library")
@Getter
@Setter
@EqualsAndHashCode
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	@OneToOne
	@JoinColumn(name = "coordinates_id")
	private Coordinates coordinates;

	@ManyToMany(mappedBy = "libraries")//--> ici je dois ajouter un attribut "stock" à ma table de liaison, mais comment faire via hibernate
	private List<Book> books;

}//end Library