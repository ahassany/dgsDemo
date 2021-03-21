package ps.hassany.dgsDemo.dataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import ps.hassany.dgsDemo.DgsConstants;
import ps.hassany.dgsDemo.service.MovieService;
import ps.hassany.dgsDemo.types.Movie;

import java.util.List;

@DgsComponent
public class MovieDataFetcher {

  private final MovieService movieService;

  public MovieDataFetcher(MovieService movieService) {
    this.movieService = movieService;
  }

  @DgsData(parentType = DgsConstants.QUERY_TYPE, field = DgsConstants.QUERY.Movies)
  public List<Movie> movies(@InputArgument("titleFilter") String titleFilter) {
    return movieService.getMovies(titleFilter);
  }
}
