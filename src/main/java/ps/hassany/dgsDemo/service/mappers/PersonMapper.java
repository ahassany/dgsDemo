package ps.hassany.dgsDemo.service.mappers;

import org.mapstruct.Mapper;
import ps.hassany.dgsDemo.domain.PersonEntity;
import ps.hassany.dgsDemo.types.Person;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
  Person toPerson(PersonEntity personEntity);
  List<Person> toPeople(List<PersonEntity> peopleEntity);
}
