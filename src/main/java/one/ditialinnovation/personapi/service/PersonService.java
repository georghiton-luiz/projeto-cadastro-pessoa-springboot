package one.ditialinnovation.personapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import one.ditialinnovation.personapi.dto.response.MessageResponseDTO;
import one.ditialinnovation.personapi.entity.Person;
import one.ditialinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {
    
    private PersonRepository personRepository;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public MessageResponseDTO createPerson(Person person){

        Person SavedPerson = personRepository.save(person);
        return MessageResponseDTO
        .builder()
        .message("Created person with ID " + SavedPerson.getId())
        .build();
    }
}
