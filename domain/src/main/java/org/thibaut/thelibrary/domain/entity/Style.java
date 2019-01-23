package org.thibaut.thelibrary.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-jan.-2019 04:53:12
 */
@Entity
@Table(name = "style")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Style {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany(mappedBy = "styles")
	private List<Book> books;

	private String style;

}
