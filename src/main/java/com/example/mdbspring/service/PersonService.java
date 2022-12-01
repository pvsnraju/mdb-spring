package com.example.mdbspring.service;

import com.example.mdbspring.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {
    Long save(Person person);

    List<Person> getPersonStartWithFirstName(String name);

    void deleteByPersonId(Long personId);

    List<Person> getByPersonAge(Integer minAge, Integer maxAge);
}
