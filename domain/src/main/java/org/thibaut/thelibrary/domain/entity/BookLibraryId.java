package org.thibaut.thelibrary.domain.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Thibaut
 * @version 1.0
 * @created 17-déc.-2018 16:49:26
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BookLibraryId implements Serializable {

	private Integer bookId;
	private Integer libraryId;
}
