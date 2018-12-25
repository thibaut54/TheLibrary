package org.thibaut.thelibrary.repository;

import org.thibaut.thelibrary.domain.entity.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface CoordinatesRepository extends JpaRepository< Coordinates, Integer >, QuerydslPredicateExecutor<Coordinates> {
}
