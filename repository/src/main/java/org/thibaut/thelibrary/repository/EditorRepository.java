package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository< Editor, Integer >, QuerydslPredicateExecutor<Editor> {
}
