package com.rodzyn.homework09nosql.repository;

import com.rodzyn.homework09nosql.model.PersonNoSql;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalNoSqlRepo extends MongoRepository<PersonNoSql, String> {
}
