package dev.alejandro.repositories;

import dev.alejandro.contracts.InterfaceDatabase;
import dev.alejandro.db.Database;
import dev.alejandro.models.Moment;

import java.util.ArrayList;
import java.util.List;

public class MomentRepository {

    private InterfaceDatabase db;

    private List<Moment> moments = new ArrayList<>(); // Simula una base de datos en memoria
    private int currentId = 1;
    

    public void storeMoment(Moment moment) { // Crea (store)
        moment.setId(currentId++);
        moments.add(moment);
        if (db != null) {
            db.store(moment);
        }
    }

    public void setDb(String db) {
        if ("momentsDatabase".equals(db)) {
            this.db = new Database();
        }
    }

    public List<Moment> getAllMoments() { // Lee todos los momentos
        return db != null ? db.getAllMoments() : new ArrayList<>(moments); // Copia para evitar modificaciones externas
    }

    public Moment getMomentById(int id) { // Lee por ID
        return moments.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateMoment(Moment updatedMoment) { // Actualiza
        for (int i = 0; i < moments.size(); i++) {
            if (moments.get(i).getId() == updatedMoment.getId()) {
                moments.set(i, updatedMoment);
                return;
            }
        }
    }

    public void deleteMoment(int id) { // Elimina
        moments.removeIf(m -> m.getId() == id);
        if (db != null) {
            db.deleteMoment(id);
        }
    }

    // Nuevo: filtrar por tipo de momento (bueno/malo)
    public List<Moment> getMomentsByType(boolean isGood) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment m : getAllMoments()) {
            if (m.isGood() == isGood) {
                filtered.add(m);
            }
        }
        return filtered;
    }

    // Nuevo: filtrar por emoción
    public List<Moment> getMomentsByEmotion(String emotion) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment m : getAllMoments()) {
            if (m.getEmotion().toString().equalsIgnoreCase(emotion)) {
                filtered.add(m);
            }
        }
        return filtered;
    }

    // Nuevo: filtrar por mes
    public List<Moment> getMomentsByMonth(int month) {
        List<Moment> filtered = new ArrayList<>();
        for (Moment m : getAllMoments()) {
            if (m.getMomentDate().getMonthValue() == month) {
                filtered.add(m);
            }
        }
        return filtered;
    }
}