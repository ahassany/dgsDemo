package ps.hassany.dgsDemo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import ps.hassany.dgsDemo.domain.PersonEntity;

import java.util.List;

public interface PersonRepository extends Neo4jRepository<PersonEntity, String> {
  @Query("MATCH (m:Movie)<-[:DIRECTED]-(person:Person) WHERE m.title = $title RETURN person")
  List<PersonEntity> findDirectorsByMovie(String title);
}
