package one.ditialinnovation.personapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import one.ditialinnovation.personapi.dto.request.PersonDTO;
import one.ditialinnovation.personapi.dto.response.MessageResponseDTO;
import one.ditialinnovation.personapi.entity.Person;
import one.ditialinnovation.personapi.exception.PersonNotFoundException;
import one.ditialinnovation.personapi.mapper.PersonMapper;
import one.ditialinnovation.personapi.repository.PersonRepository;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;


    @Autowired
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

    public PersonDTO findById(Long id) throws PersonNotFoundException{
        Person person = verifyIfExists(id);
        
        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException{

        verifyIfExists(id);
        
        personRepository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException{

        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person  updatePerson = personRepository.save(personToUpdate);
        return MessageResponseDTO
        .builder()
        .message("Update person with ID " + updatePerson.getId())
        .build();
    }


}
