package personas.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    public static Person findPersonById (Collection<Person> listPerson, Long id) {
        return listPerson.stream()
                         .filter(x -> x.getId()== id)
                         .findAny()
                         .orElse(null);

    }

    public static Person delete (Map<Long,Person> mapsPerson, Person person) {
        /*
        Entiendo que aca deberia borrar sobre la base de datos.
         */
        HashMap <Long, Person> hashMapPersons = new HashMap<Long, Person>(mapsPerson);
        hashMapPersons.remove(person.getId(),person);
        return person;
    }

}
