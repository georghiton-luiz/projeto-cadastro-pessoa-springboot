package one.ditialinnovation.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import one.ditialinnovation.personapi.dto.request.PersonDTO;
import one.ditialinnovation.personapi.dto.response.MessageResponseDTO;
import one.ditialinnovation.personapi.entity.Person;
import one.ditialinnovation.personapi.mapper.PersonMapper;
import one.ditialinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public MessageResponseDTO createPerson(PersonDTO personDTO){

        Person personToSave = personMapper.toModel(personDTO);

        Person  SavedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
        .builder()
        .message("Created person with ID " + SavedPerson.getId())
        .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
        .map(personMapper::toDTO)
        .collect(Collectors.toList());
    }
}
