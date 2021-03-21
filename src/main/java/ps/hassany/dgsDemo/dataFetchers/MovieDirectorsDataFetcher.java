package ps.hassany.dgsDemo.dataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.dataloader.DataLoader;
import ps.hassany.dgsDemo.DgsConstants;
import ps.hassany.dgsDemo.dataLoaders.MovieDirectorsDataLoader;
import ps.hassany.dgsDemo.types.Movie;
import ps.hassany.dgsDemo.types.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class MovieDirectorsDataFetcher {

  @DgsData(parentType = DgsConstants.MOVIE.TYPE_NAME, field = DgsConstants.MOVIE.Directors)
  public CompletableFuture<List<Person>> directors(DgsDataFetchingEnvironment dfe) {
    DataLoader<String, List<Person>> directorsDataLoader =
        dfe.getDataLoader(MovieDirectorsDataLoader.class);
    Movie movie = dfe.getSource();
    return directorsDataLoader.load(movie.getTitle());
  }
}
