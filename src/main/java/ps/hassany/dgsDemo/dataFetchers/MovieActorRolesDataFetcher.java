package ps.hassany.dgsDemo.dataFetchers;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.dataloader.DataLoader;
import ps.hassany.dgsDemo.DgsConstants;
import ps.hassany.dgsDemo.dataLoaders.MovieActorRolesDataLoader;
import ps.hassany.dgsDemo.types.Movie;
import ps.hassany.dgsDemo.types.Role;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class MovieActorRolesDataFetcher {
  @DgsData(parentType = DgsConstants.MOVIE.TYPE_NAME, field = DgsConstants.MOVIE.Actors)
  public CompletableFuture<List<Role>> actorRoles(DgsDataFetchingEnvironment dfe) {
    DataLoader<String, List<Role>> dataLoader = dfe.getDataLoader(MovieActorRolesDataLoader.class);
    Movie movie = dfe.getSource();
    return dataLoader.load(movie.getTitle());
  }
}
