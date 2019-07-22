package org.thibaut.thelibrary.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-dec.-2018 16:49:15
 */
@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(mappedBy = "roles")
	private List< UserEntity > users;

	private String role;

}
