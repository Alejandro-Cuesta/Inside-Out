package dev.alejandro.repositories;

import dev.alejandro.dtos.MovieDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository {

    private List<MovieDTO> movies = new ArrayList<>();

    public void addMovie(MovieDTO movie) {
        movies.add(movie);
    }

    public List<MovieDTO> getAllMovies() {
        return new ArrayList<>(movies);
    }

    public List<MovieDTO> getMoviesByGenre(String genre) {
        return movies.stream()
                     .filter(m -> m.getGenres().stream()
                                   .anyMatch(g -> g.equalsIgnoreCase(genre)))
                     .collect(Collectors.toList());
    }
}