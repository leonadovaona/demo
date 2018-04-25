package personas.example.demo.DAO;

import java.util.List;

import personas.example.demo.Person;

public interface IPersonDAO {
    List<Person> getAllPersons();
    Person getPersonById(int id);
    void addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int id);
}