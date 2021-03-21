package ps.hassany.dgsDemo.service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ps.hassany.dgsDemo.domain.MovieEntity;
import ps.hassany.dgsDemo.types.Movie;

@Mapper(
    componentModel = "spring",
    uses = {PersonMapper.class, RoleMapper.class})
@Component
public interface MovieMapper {

  @Mapping(source = "movieEntity.actorsAndRoles", target = "actors")
  Movie toMovie(MovieEntity movieEntity);
}
