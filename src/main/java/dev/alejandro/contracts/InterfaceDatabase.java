package dev.alejandro.contracts;

import java.util.List;

import dev.alejandro.models.Moment;

public interface InterfaceDatabase {
    public void store(Moment moment);
    public List<Moment> getAllMoments();
    public void deleteMoment(int id);
}
