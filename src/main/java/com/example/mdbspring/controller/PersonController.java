package com.example.mdbspring.controller;

import com.example.mdbspring.model.Person;
import com.example.mdbspring.service.PersonService;
import com.example.mdbspring.service.SequenceGeneratorService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @PostMapping
    public Long save(@RequestBody Person person){
        person.setPersonId(sequenceGeneratorService.generateSequence(Person.SEQUENCE_NAME));
        return personService.save(person);
    }

    @GetMapping
    public List<Person> getPersonStartWithFirstName(@RequestParam("name") String name){
        return personService.getPersonStartWithFirstName(name);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteByPersonId(@PathVariable("id") Long personId){
        try {
            personService.deleteByPersonId(personId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/age")
    public List<Person> getByPersonAge(@RequestParam("minAge") Integer minAge,
                                       @RequestParam("maxAge") Integer maxAge){
        return personService.getByPersonAge(minAge, maxAge);
    }
}
