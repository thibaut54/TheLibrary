package org.thibaut.thelibrary.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.Author;
import org.thibaut.thelibrary.domain.entity.Book;
import org.thibaut.thelibrary.domain.entity.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository< Book, Integer > {

	public List<Book> getBooksByTitleContainsAndAuthorsContainsAndCategoriesContains( String title, List< Author > authors, Category style );

	public List<Book> getBooksByTitleContains(String title);
	public List<Book> findAllByTitleContains(String title);

	@Query("select book from Book as book where book.title like :title")
	public List<Book> findBookByTitleContains(@Param( "title" ) String title);
}
