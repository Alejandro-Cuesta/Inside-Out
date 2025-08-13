package dev.alejandro.repositories;

import dev.alejandro.models.Moment;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepository {

    
    private List<Moment> moments = new ArrayList<>(); //Simula una base de datos en memoria//
    private int currentId = 1;

    public void storeCharacter(Moment moment) { //Crea (store)//
        moment.setId(currentId++);
        moments.add(moment);
    }

    public List<Moment> getAllCharacters() { //Lee todos los momentos//
        return new ArrayList<>(moments); // Devulve una copia para evitar modificaciones externas//
    }

    public Moment getCharacterById(int id) {  //Lee  por ID//
        return moments.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateCharacter(Moment updatedMoment) {  //Actualiza//
        for (int i = 0; i < moments.size(); i++) {
            if (moments.get(i).getId() == updatedMoment.getId()) {
                moments.set(i, updatedMoment);
                return;
            }
        }
    }

    public void deleteCharacter(int id) { //Elimina//
        moments.removeIf(m -> m.getId() == id);
    }
}
