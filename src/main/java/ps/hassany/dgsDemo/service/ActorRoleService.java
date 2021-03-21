package ps.hassany.dgsDemo.service;

import org.springframework.stereotype.Service;
import ps.hassany.dgsDemo.repository.MovieRepository;
import ps.hassany.dgsDemo.service.mappers.RoleMapper;
import ps.hassany.dgsDemo.types.Role;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorRoleService {
  private final RoleMapper roleMapper;
  private final MovieRepository movieRepository;

  public ActorRoleService(MovieRepository movieRepository, RoleMapper roleMapper) {
    this.movieRepository = movieRepository;
    this.roleMapper = roleMapper;
  }

  public List<Role> getActorsByMovie(String movieTitle) {
    var movies = movieRepository.findMovieAndActors(movieTitle);
    if (movies == null || movies.get(0).getActorsAndRoles() == null) {
      return null;
    }
    return movies.get(0).getActorsAndRoles().stream()
        .map(roleMapper::toRole)
        .collect(Collectors.toList());
  }
}
