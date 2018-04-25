package personas.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import personas.example.demo.Core.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}

