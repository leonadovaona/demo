package personas.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {

    public Person findPersonById (Collection<Person> listPerson, Long id) {
        return listPerson.stream()
                .filter(x -> x.getId()== id)
                .findAny()
                .orElse(null);

    }
    /* Borra una persona */
    public Person delete (Map<Long,Person> mapsPerson, Person person) {
        mapsPerson.remove(person.getId());
        return person;
    }
    /* Borra todos */
    public void deleteAll (Map<Long,Person> mapsPerson) {
        mapsPerson.clear();
    }
}
