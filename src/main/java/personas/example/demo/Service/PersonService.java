package personas.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import personas.example.demo.Core.Person;
import personas.example.demo.repository.PersonRepository;


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
