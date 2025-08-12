package dev.alejandro.db;

import dev.alejandro.models.Moment;
import dev.alejandro.repositories.CharacterRepository;

import java.util.ArrayList;
import java.util.List;

public class DataBase implements CharacterRepository {
    private final List<Moment> moments = new ArrayList<>();

    @Override
    public List<Moment> findAll() {
        return new ArrayList<>(moments);
    }

    @Override
    public void save(Moment moment) {
        moments.add(moment);
    }
}