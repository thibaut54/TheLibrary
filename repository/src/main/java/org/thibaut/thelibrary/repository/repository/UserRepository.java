package org.thibaut.thelibrary.repository.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thibaut.thelibrary.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository< User, Integer >, QuerydslPredicateExecutor<User> {

	@Transactional
	User findByUserName( String username );

	@Transactional
	@Query( "SELECT user FROM User AS user JOIN  user.coordinates AS coordinates WHERE coordinates.email =: email" )
	User findByEmail( @Param( "email" ) String email );


}
