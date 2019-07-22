package org.thibaut.thelibrary.domain.entity;


import lombok.*;

import javax.persistence.*;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;
	private String firstName;
	private String lastName;
	private String userName;
//	private LocalDateTime registrationDate;

	@ManyToMany
	@JoinTable(
			name = "roles_of_users",
			joinColumns = { @JoinColumn(name = "user_id") },
			inverseJoinColumns = { @JoinColumn(name = "role_id") } )
	private List< RoleEntity > roles;

	@OneToOne
	@JoinColumn(name = "coordinates_id")
	private CoordinatesEntity coordinates;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List< LoanEntity > loans;


}
