package personas.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/persons")
public class PersonaController {
    private Map<Long,Person> mapPersons = new HashMap<Long,Person>();
    private List<Person>PersonList = new ArrayList<Person>();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity person() {
        return new ResponseEntity<Map<Long,Person>>(mapPersons, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPersona(@PathVariable Long id){
        Person person = PersonaService.findPersonById(PersonList,id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person nuevaPerson = new Person();
        nuevaPerson.setId(person.getId());
        nuevaPerson.setName(person.getName());
        nuevaPerson.setLastname(person.getLastname());
        nuevaPerson.setAddress(person.getAddress());
        nuevaPerson.setNacionality(person.getNacionality());
        this.mapPersons.put(nuevaPerson.getId(), nuevaPerson);
        PersonList = new ArrayList<Person>(mapPersons.values());
        return new ResponseEntity<Person>(nuevaPerson, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePerson (@RequestBody Person person){
        Person p = PersonaService.findPersonById(PersonList, person.getId());
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
        return new ResponseEntity<Map<Long,Person>>(mapPersons, HttpStatus.OK);
    }
}


