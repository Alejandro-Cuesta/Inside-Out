package dev.alejandro.repositories;

import dev.alejandro.models.Moment;

import java.util.List;

public interface CharacterRepository {
    List<Moment> findAll();
    void save(Moment moment);
}