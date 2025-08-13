package dev.alejandro.controllers;

import dev.alejandro.dtos.CharacterDTOInput;
import dev.alejandro.dtos.CharacterDTOOutput;
import dev.alejandro.mappers.CharacterMapper;
import dev.alejandro.models.Moment;
import dev.alejandro.repositories.CharacterRepository;

import java.util.List;

public class CharacterController {

    private CharacterRepository repository;

    public CharacterController(CharacterRepository repository) {
        this.repository = repository;
    }

    public void storeCharacter(CharacterDTOInput dto) { //Crea un nuevo momento//
        Moment moment = CharacterMapper.toEntity(dto);
        repository.storeCharacter(moment);
    }

    public List<CharacterDTOOutput> listCharacters() {  //Lista todos los momentos//
        List<Moment> moments = repository.getAllCharacters();
        return CharacterMapper.toDTOList(moments);
    }

    public CharacterDTOOutput getCharacterById(int id) {  //Busca un momento por ID//
        Moment moment = repository.getCharacterById(id);
        return moment != null ? CharacterMapper.toDTO(moment) : null;
    }

    public void updateCharacter(CharacterDTOInput dto) { //Actualiza un momento existente//
        Moment moment = CharacterMapper.toEntity(dto);
        repository.updateCharacter(moment);
    }

    public void deleteCharacter(int id) { //Elimina un momento//
        repository.deleteCharacter(id);
    }
}