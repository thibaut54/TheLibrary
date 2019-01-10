package org.thibaut.thelibrary.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.Book;

@Repository
public interface BookRepository extends JpaRepository< Book, Integer >, QuerydslPredicateExecutor<Book> {
}
