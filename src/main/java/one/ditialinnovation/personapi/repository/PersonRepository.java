package one.ditialinnovation.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import one.ditialinnovation.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
    
}
