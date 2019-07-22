package org.thibaut.thelibrary.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:31:51
 */
@Entity
@Table(name = "loan")
@Getter
@Setter
@EqualsAndHashCode
public class LoanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private LocalDate startDate;
	private boolean returned = false;
	private LocalDate initialEndDate;
	private LocalDate extendedEndDate;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private BookEntity book;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

}//end LoanEntity
