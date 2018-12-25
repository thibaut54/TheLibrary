package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User, Integer >, QuerydslPredicateExecutor<User> {
}
