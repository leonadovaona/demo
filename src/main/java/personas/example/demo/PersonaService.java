package personas.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonaService {

        public static Person findPersonById (List<Person> listPerson, Long id) {
            return listPerson.stream()
                    .filter(x -> x.getId()== id)
                    .findAny()
                    .orElse(null);

    }

    public static Person delete (Map<Long,Person> mapsPerson, Person person) {
        mapsPerson.remove(person.getId(),person);
        return person;
    }

}
