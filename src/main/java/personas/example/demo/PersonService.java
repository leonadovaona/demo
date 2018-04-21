package personas.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    public Person findPersonById (Collection<Person> listPerson, Long id) {
        return listPerson.stream()
                         .filter(x -> x.getId()== id)
                         .findAny()
                         .orElse(null);

    }

    public Person delete (Map<Long,Person> mapsPerson, Person person) {
        mapsPerson.remove(person.getId());
        return person;
    }

}
