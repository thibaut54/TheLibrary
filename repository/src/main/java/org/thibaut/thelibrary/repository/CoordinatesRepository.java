package org.thibaut.thelibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.thibaut.thelibrary.domain.entity.Coordinates;


@Repository
public interface CoordinatesRepository extends JpaRepository< Coordinates, Integer >, QuerydslPredicateExecutor<Coordinates> {
}
