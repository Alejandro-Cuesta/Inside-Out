package dev.alejandro.controllers;

import dev.alejandro.dtos.MovieDTO;
import dev.alejandro.repositories.MovieRepository;
import dev.alejandro.singletons.MovieRepositorySingleton;

import java.util.List;

public class MovieController {

    private final MovieRepository repository;

    public MovieController() {
        this.repository = MovieRepositorySingleton.getInstance();
    }

    public void addMovie(MovieDTO movie) {
        repository.addMovie(movie);
    }

    public List<MovieDTO> listMovies() {
        return repository.getAllMovies();
    }

    public List<MovieDTO> getMoviesByGenre(String genre) {
        return repository.getMoviesByGenre(genre);
    }
}