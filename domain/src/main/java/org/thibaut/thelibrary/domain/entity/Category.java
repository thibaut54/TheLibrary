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
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany(mappedBy = "categories")
	private List<Book> books;

	private String category;

}