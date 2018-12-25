package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository< Book, Integer >, QuerydslPredicateExecutor<Book> {
}
