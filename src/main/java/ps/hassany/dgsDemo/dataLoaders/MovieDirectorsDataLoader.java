package ps.hassany.dgsDemo.dataLoaders;

import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.BatchLoader;
import ps.hassany.dgsDemo.service.PersonService;
import ps.hassany.dgsDemo.types.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

@DgsDataLoader(name = "directors")
public class MovieDirectorsDataLoader implements BatchLoader<String, List<Person>> {

  private PersonService personService;

  public MovieDirectorsDataLoader(PersonService personService) {
    this.personService = personService;
  }

  @Override
  public CompletionStage<List<List<Person>>> load(List<String> keys) {
    return CompletableFuture.supplyAsync(
        () ->
            keys.stream()
                .parallel()
                .map(personService::getDirectorsByMovie)
                .collect(Collectors.toList()));
  }
}
