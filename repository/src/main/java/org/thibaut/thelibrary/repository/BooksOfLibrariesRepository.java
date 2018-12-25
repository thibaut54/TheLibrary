package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.BooksOfLibraries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksOfLibrariesRepository extends JpaRepository< BooksOfLibraries, Integer >, QuerydslPredicateExecutor<BooksOfLibraries> {
}
