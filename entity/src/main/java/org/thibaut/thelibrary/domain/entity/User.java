package org.thibaut.thelibrary.domain.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:49:26
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String password;
	private String firstName;
	private String lastName;
	private String userName;
	private LocalDateTime registrationDate;

	@ManyToMany
	@JoinTable(
			name = "roles_of_users",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") } )
	private List< Role > roles;

	@OneToOne
	@JoinColumn(name = "coordinates_id")
	private Coordinates coordinates;

	@OneToMany(mappedBy = "user")
	private List< Loan > loans;


}
