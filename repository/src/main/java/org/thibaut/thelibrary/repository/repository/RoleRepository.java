package org.thibaut.thelibrary.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository< Role, Integer >, QuerydslPredicateExecutor< Role > {

	Role findByRoleLike( String role );
}
