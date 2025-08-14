package dev.alejandro.controllers;

import dev.alejandro.dtos.MomentDTOInput;
import dev.alejandro.dtos.MomentDTOOutput;
import dev.alejandro.mappers.MomentMapper;
import dev.alejandro.models.Moment;
import dev.alejandro.repositories.MomentRepository;
import dev.alejandro.singletons.MomentRepositorySingleton;

import java.util.List;

public class MomentController {

    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();

    }

    public MomentController(MomentRepository repository) {
        this.repository = repository;
    }

    public void storeCharacter(MomentDTOInput dto) { //Crea un nuevo momento//
        Moment moment = MomentMapper.toEntity(dto);
        repository.storeMoment(moment);
    }

    public List<MomentDTOOutput> listMoments() {  //Lista todos los momentos//
        List<Moment> moments = repository.getAllMoments();
        return MomentMapper.toDTOList(moments);
    }

    public MomentDTOOutput getMomentById(int id) {  //Busca un momento por ID//
        Moment moment = repository.getMomentById(id);
        return moment != null ? MomentMapper.toDTO(moment) : null;
    }

    public void updateMoment(MomentDTOInput dto) { //Actualiza un momento existente//
        Moment moment = MomentMapper.toEntity(dto);
        repository.updateMoment(moment);
    }

    public void deleteMoment(int id) { //Elimina un momento//
        repository.deleteMoment(id);
    }

    


}