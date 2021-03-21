package ps.hassany.dgsDemo.service;

import org.springframework.stereotype.Service;
import ps.hassany.dgsDemo.repository.PersonRepository;
import ps.hassany.dgsDemo.service.mappers.PersonMapper;
import ps.hassany.dgsDemo.types.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
  private final PersonRepository personRepository;
  private final PersonMapper personMapper;

  public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
    this.personRepository = personRepository;
    this.personMapper = personMapper;
  }

  public List<Person> getDirectorsByMovie(String title) {
    var directors = personRepository.findDirectorsByMovie(title);
    return directors.stream().map(personMapper::toPerson).collect(Collectors.toList());
  }
}
