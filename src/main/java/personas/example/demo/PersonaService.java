package personas.example.demo;

import java.util.List;

public class PersonaService {

    public static Person findPersonById (List<Person> listPerson, Integer id) {
        return (Person) listPerson.stream().filter(p -> p.getId() == id);
    }

    public static void delete (List<Person> listPerson, Integer id) {
        listPerson.remove(findPersonById(listPerson,id));
    }

}
