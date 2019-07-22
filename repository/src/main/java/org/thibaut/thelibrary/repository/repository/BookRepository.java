package org.thibaut.thelibrary.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.AuthorEntity;
import org.thibaut.thelibrary.domain.entity.BookEntity;
import org.thibaut.thelibrary.domain.entity.CategoryEntity;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository< BookEntity, Integer > {

	public List< BookEntity > getBooksByTitleContainsAndAuthorsContainsAndCategoriesContains( String title, List< AuthorEntity > authors, CategoryEntity style );

	public List< BookEntity > getBooksByTitleContains( String title);
	public List< BookEntity > findAllByTitleContains( String title);

	@Query("select book from BookEntity as book where book.title like :title")
	public List< BookEntity > findBookByTitleContains( @Param( "title" ) String title);
}
