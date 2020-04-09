package com.rodzyn.homework09nosql.repository;

import com.rodzyn.homework09nosql.model.PersonSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonSqlRepo extends JpaRepository<PersonSql, Long> {
}
