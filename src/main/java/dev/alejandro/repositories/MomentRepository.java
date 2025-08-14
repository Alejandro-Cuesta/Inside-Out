package dev.alejandro.repositories;

import dev.alejandro.contracts.InterfaceDatabase;
import dev.alejandro.db.Database;
import dev.alejandro.models.Moment;

import java.util.ArrayList;
import java.util.List;

public class MomentRepository {

    private InterfaceDatabase db;
    
    private List<Moment> moments = new ArrayList<>(); //Simula una base de datos en memoria//
    private int currentId = 1;

    public void storeMoment(Moment moment) { //Crea (store)//
        moment.setId(currentId++);
        moments.add(moment);
    }

    public void setDb(String db) {
        if (db == "momentsDatabase") this.db = new Database();
    }

    public List<Moment> getAllMoments() { //Lee todos los momentos//
        return db.getAll(); // Devulve una copia para evitar modificaciones externas//
    }

    public Moment getMomentById(int id) {  //Lee  por ID//
        return moments.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateMoment(Moment updatedMoment) {  //Actualiza//
        for (int i = 0; i < moments.size(); i++) {
            if (moments.get(i).getId() == updatedMoment.getId()) {
                moments.set(i, updatedMoment);
                return;
            }
        }
    }

    public void deleteMoment(int id) { //Elimina//
        moments.removeIf(m -> m.getId() == id);
    }
}
