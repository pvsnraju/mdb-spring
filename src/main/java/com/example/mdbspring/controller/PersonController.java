package com.example.mdbspring.controller;

import com.example.mdbspring.model.Person;
import com.example.mdbspring.service.PersonService;
import com.example.mdbspring.service.SequenceGeneratorService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/search")
    public Page<Person> searchPerson(@RequestParam(required = false) String name,
                                     @RequestParam(required = false) Integer minAge,
                                     @RequestParam(required = false) Integer maxAge,
                                     @RequestParam(required = false) String city,
                                     @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "5") Integer size){

        Pageable pageable = PageRequest.of(page,size);

        return personService.search(name,minAge,maxAge,city,pageable);
    }
    @GetMapping("/oldestPerson")
    public List<Document> getOldestPerson(){
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/populationByCity")
    public List<Document> getPopuplationByCity(){
        return personService.getPopulationByCity();
    }
}
