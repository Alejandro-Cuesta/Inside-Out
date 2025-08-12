package dev.alejandro.insideout.service;

import dev.alejandro.insideout.model.Moment;
import dev.alejandro.insideout.model.Emotion;

import java.time.LocalDate;
import java.util.List;

 //Aquí irá toda la lógica: añadir, eliminar, listar y filtrar momentos//
public class Diary {

    public Diary() { //Constructor

    }

    public void addMoment(Moment moment) { //Añadir momento//

    }
    
    public List<Moment> getallMoments() { //Devolveer todos los momentos//

        return null;
    }

    public boolean removeMomentById(int id) { //Eliminar metodo po Id//

        return false;
    }

    public List<Moment> filterByEmotion(Emotion emotion) { //Devolver metodos que coincidad con una emocion//

        return null; 
    }

    public List<Moment> filterByDate(LocalDate date) { //Devolver metodos que coincidan con la fecha//

        return null;
    }
}
