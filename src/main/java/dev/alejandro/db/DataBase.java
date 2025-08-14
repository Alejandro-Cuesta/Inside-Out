package dev.alejandro.db;

import dev.alejandro.contracts.InterfaceDatabase;
import dev.alejandro.models.Moment;

import java.util.ArrayList;
import java.util.List;

public class Database implements InterfaceDatabase {
    private final List<Moment> moments = new ArrayList<>();

    @Override
    public List<Moment> getAll() {
        return  moments;
    }

    @Override
    public void store(Moment moment) {
        moments.add(moment);
    }

    @Override
    public void deleteMoment(int id) {
        moments.remove(id);
    }
}