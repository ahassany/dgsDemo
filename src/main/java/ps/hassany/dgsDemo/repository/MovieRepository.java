package ps.hassany.dgsDemo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import ps.hassany.dgsDemo.domain.MovieEntity;

import java.util.List;

public interface MovieRepository extends Neo4jRepository<MovieEntity, String> {

  @Query("MATCH (m:Movie) WHERE m.title contains $title RETURN m")
  List<MovieEntity> findByTitle(String title);

  @Query(
      "MATCH (movie:Movie)<-[r:ACTED_IN]-(p:Person) WHERE movie.title = $title RETURN movie, collect(r), collect(p)")
  List<MovieEntity> findMovieAndActors(String title);
}
