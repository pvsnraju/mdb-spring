package com.example.mdbspring.service;

import com.example.mdbspring.model.Person;
import com.example.mdbspring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepository;
    @Override
    public Long save(Person person) {
        return personRepository.save(person).getPersonId();
    }

    @Override
    public List<Person> getPersonStartWithFirstName(String name) {
        return personRepository.findByFirstNameStartsWith(name);
    }

    @Override
    public void deleteByPersonId(Long personId) {
        personRepository.deleteById(personId);
    }

    @Override
    public List<Person> getByPersonAge(Integer minAge, Integer maxAge) {
        //return personRepository.findByAgeBetween(minAge,maxAge);
        return personRepository.findByPersonAgeBetween(minAge,maxAge);
    }
}
