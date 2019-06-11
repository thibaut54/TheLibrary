package org.thibaut.thelibrary.repository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.Role;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository< Role, Integer >, QuerydslPredicateExecutor< Role > {

	@Query("SELECT role FROM Role role JOIN role.users user WHERE user.id =: id")
	List<Role> findRolesByUserId( @Param( "user_id" ) Long id);

	//	@Query("SELECT r.role FROM Role r WHERE r.role =:role")
	List<Role> findRolesByRoleContains( String role );

	Role findByRoleLike( String role );
}
