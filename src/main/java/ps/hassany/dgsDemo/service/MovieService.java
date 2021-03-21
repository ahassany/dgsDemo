package ps.hassany.dgsDemo.service;

import org.springframework.stereotype.Service;
import ps.hassany.dgsDemo.domain.MovieEntity;
import ps.hassany.dgsDemo.repository.MovieRepository;
import ps.hassany.dgsDemo.service.mappers.MovieMapper;
import ps.hassany.dgsDemo.service.mappers.PersonMapper;
import ps.hassany.dgsDemo.types.Movie;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
  private MovieRepository movieRepository;
  private MovieMapper movieMapper;
  private PersonMapper personMapper;

  public MovieService(
      MovieRepository movieRepository, MovieMapper movieMapper, PersonMapper personMapper) {
    this.movieRepository = movieRepository;
    this.movieMapper = movieMapper;
    this.personMapper = personMapper;
  }

  public List<Movie> getMovies(String titleFilter) {
    List<MovieEntity> movieEntities;
    movieEntities =
        titleFilter == null ? movieRepository.findAll() : movieRepository.findByTitle(titleFilter);
    return movieEntities.stream().map(movieMapper::toMovie).collect(Collectors.toList());
  }
}
