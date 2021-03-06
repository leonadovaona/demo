package personas.example.demo.Controller;

import personas.example.demo.Person;
import personas.example.demo.Service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.*;



@RestController
@RequestMapping("/persons")
@ComponentScan (basePackages = "personas.example.demo")

public class PersonController {
    @Autowired
    private PersonService personService;
    private Map<Long,Person> mapPersons = new HashMap<Long,Person>();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity person() {
        return new ResponseEntity<Collection<Person>>(mapPersons.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPersona(@PathVariable Long id){

        return new ResponseEntity<Person>(personService.findPersonById(mapPersons.values(),id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person newPerson = new Person();
        newPerson.setId(person.getId());
        newPerson.setName(person.getName());
        newPerson.setLastname(person.getLastname());
        newPerson.setAddress(person.getAddress());
        newPerson.setNacionality(person.getNacionality());
        this.mapPersons.put(newPerson.getId(), newPerson);
        return new ResponseEntity<Person>(newPerson, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePerson (@PathVariable Long id, @RequestBody Person person){
        Person p = personService.findPersonById(mapPersons.values(), id);
        p.setName(person.getName());
        p.setLastname(person.getLastname());
        p.setAddress(person.getAddress());
        p.setNacionality(person.getNacionality());
        this.mapPersons.put(p.getId(),p);

        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePerson (@PathVariable Long id){
        Person person = personService.delete(mapPersons, personService.findPersonById(mapPersons.values(),id));
        this.mapPersons.remove(person.getId());
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteAllPersons (){
        personService.deleteAll(mapPersons);
        mapPersons.clear();
        return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
    }
}


