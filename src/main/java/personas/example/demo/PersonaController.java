package personas.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/persons")
public class PersonaController {
    private Map<Long,Person> mapPersons = new HashMap<Long,Person>();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity person() {
        return new ResponseEntity<Collection<Person>>(mapPersons.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPersona(@PathVariable Long id){
        //Person person = PersonaService.findPersonById(PersonList,id);
        return new ResponseEntity<Person>(PersonaService.findPersonById(mapPersons.values(),id), HttpStatus.OK);
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

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePerson (@RequestBody Person person){
        Person p = PersonaService.findPersonById(mapPersons.values(), person.getId());
        p.setName(person.getName());
        p.setLastname(person.getLastname());
        p.setAddress(person.getAddress());
        p.setNacionality(person.getNacionality());
        this.mapPersons.put(p.getId(),p);
        return new ResponseEntity<Person>(p, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deletePerson (@RequestBody Person person){
        person = PersonaService.delete(mapPersons, person);
        this.mapPersons.remove(person.getId(), person);
        return new ResponseEntity<Collection<Person>>(mapPersons.values(), HttpStatus.OK);
    }
}


