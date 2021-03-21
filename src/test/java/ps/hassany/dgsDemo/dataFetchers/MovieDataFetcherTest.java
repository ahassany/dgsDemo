package ps.hassany.dgsDemo.dataFetchers;

import com.jayway.jsonpath.TypeRef;
import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.netflix.graphql.dgs.client.codegen.GraphQLQueryRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ps.hassany.dgsDemo.client.MoviesGraphQLQuery;
import ps.hassany.dgsDemo.client.MoviesProjectionRoot;
import ps.hassany.dgsDemo.service.MovieService;
import ps.hassany.dgsDemo.types.Movie;
import ps.hassany.dgsDemo.types.Person;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MovieDataFetcherTest {
  private final String movieTitle = "The Greatest Movie ever!";
  private final String movieTagline = "Another tagline";
  private final List<Person> directors =
      List.of(new Person("Director1", 1950), new Person("Director2", 1960));
  @Autowired DgsQueryExecutor dgsQueryExecutor;
  @MockBean MovieService movieService;

  @Test
  public void movies_ShouldReturnNoDirectorsNoActors() {
    Movie expectedMovie = new Movie(movieTitle, movieTagline, null, null);
    when(movieService.getMovies(movieTitle)).thenAnswer(invocation -> List.of(expectedMovie));

    GraphQLQueryRequest query =
        new GraphQLQueryRequest(
            new MoviesGraphQLQuery.Builder().titleFilter(movieTitle).build(),
            new MoviesProjectionRoot().title().tagline());
    var result =
        dgsQueryExecutor.executeAndExtractJsonPathAsObject(
            query.serialize(), "data.movies[*]", new TypeRef<List<Movie>>() {});

    assertThat(result, is(List.of(expectedMovie)));
  }
}
