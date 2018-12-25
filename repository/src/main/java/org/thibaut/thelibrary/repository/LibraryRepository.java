package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository< Library, Integer >, QuerydslPredicateExecutor<Library> {
}
