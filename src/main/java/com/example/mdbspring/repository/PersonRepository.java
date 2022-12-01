package com.example.mdbspring.repository;

import com.example.mdbspring.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, Long> {

    List<Person> findByFirstNameStartsWith(String name);

    //List<Person> findByAgeBetween(Integer minAge, Integer maxAge);
    @Query(value = "{'age' : {$gt : ?0, $lt :?1}}")
    List<Person> findByPersonAgeBetween(Integer minAge, Integer maxAge);
}
