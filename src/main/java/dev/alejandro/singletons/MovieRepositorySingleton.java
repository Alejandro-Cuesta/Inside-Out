package dev.alejandro.singletons;

import dev.alejandro.repositories.MovieRepository;

public class MovieRepositorySingleton {
    private static MovieRepository instance;

    private MovieRepositorySingleton() {}

    public static MovieRepository getInstance() {
        if (instance == null) {
            instance = new MovieRepository();
        }
        return instance;
    }
}