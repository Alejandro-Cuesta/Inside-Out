package dev.alejandro.insideout.service;

import dev.alejandro.insideout.model.Moment;
import dev.alejandro.insideout.model.Emotion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return null; 
    }

    public List<Moment> filterByDate(LocalDate date) { //Devolver metodos que coincidan con la fecha//
        return null;
    }
}
