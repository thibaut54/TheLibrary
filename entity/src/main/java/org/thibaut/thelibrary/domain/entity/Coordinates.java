package org.thibaut.thelibrary.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:31:51
 */
@Entity
@Table(name = "coordinates")
@Getter
@Setter
@EqualsAndHashCode
public class Coordinates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String street;
	private String streetNumber;
	private String additionalInformation;
	private String city;
	private Integer postalCode;
	private Integer phone;
	private String email;


	@OneToOne(mappedBy = "coordinates") //--> la value de mappedBy, c'est le nom de la Classe qui porte la relation ou le nom de la Table en DB
	private User user;

	@OneToOne(mappedBy = "coordinates")
	private Editor editor;

	@OneToOne(mappedBy = "coordinates")
	private Library library;



}//end Coordinates