package dev.alejandro.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.alejandro.models.Emotion;
import dev.alejandro.models.Moment;

 //Aquí irá toda la lógica: añadir, eliminar, listar y filtrar momentos//
public class Diary {

    private List<Moment> moments; //lista interna para guardar momentos

    public Diary() { //Constructor
        moments = new ArrayList<>();
    }

    public void addMoment(Moment moment) { //Añadir momento//
        moments.add(moment);
    }
    
    public List<Moment> getAllMoments() { //Devolveer todos los momentos//
        return moments;
    }

    public boolean removeMomentById(int id) { //Eliminar metodo por Id//
        return moments.removeIf(moment -> moment.getId() == id);
    }

    public List<Moment> filterByEmotion(Emotion emotion) { //Devolver metodos que coincidad con una emocion//
        List<Moment> filtered = new ArrayList<>();
        for (Moment moment : moments) {
            if (moment.getEmotion() == emotion) {
                filtered.add(moment);
            }
        }
        return filtered;
    }

    public List<Moment> filterByDate(LocalDate date) { //Devolver metodos que coincidan con la fecha//
        List<Moment> filtered = new ArrayList<>();
        for (Moment moment : moments) {
            if (moment.getMomentDate().equals(date)) {
                filtered.add(moment);
            }
        }
        return filtered;
    }
}
