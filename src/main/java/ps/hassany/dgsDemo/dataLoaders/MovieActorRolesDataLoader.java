package ps.hassany.dgsDemo.dataLoaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;
import ps.hassany.dgsDemo.service.ActorRoleService;
import ps.hassany.dgsDemo.types.Role;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "actors")
public class MovieActorRolesDataLoader implements BatchLoader<String, List<Role>> {
  private ActorRoleService actorRoleService;

  public MovieActorRolesDataLoader(ActorRoleService actorRoleService) {
    this.actorRoleService = actorRoleService;
  }

  @Override
  public CompletionStage<List<List<Role>>> load(List<String> keys) {
    return CompletableFuture.supplyAsync(
        () -> keys.stream().map(actorRoleService::getActorsByMovie).collect(Collectors.toList()));
  }
}
