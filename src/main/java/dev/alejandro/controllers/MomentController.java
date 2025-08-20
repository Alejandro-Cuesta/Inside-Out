package dev.alejandro.controllers;

import dev.alejandro.dtos.MomentDTOInput;
import dev.alejandro.dtos.MomentDTOOutput;
import dev.alejandro.mappers.MomentMapper;
import dev.alejandro.models.Moment;
import dev.alejandro.repositories.MomentRepository;
import dev.alejandro.singletons.MomentRepositorySingleton;
import dev.alejandro.views.MomentFormGetView;

import java.util.ArrayList;
import java.util.List;

public class MomentController {

    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();

    }

    public void storeMoment(MomentDTOInput dto) { // Crea un nuevo momento//
        Moment momentToSave = MomentMapper.toEntity(dto);
        repository.setDb("momentsDatabase");
        repository.storeMoment(momentToSave);
    }

    public void listMoments() {
        List<MomentDTOOutput> momentDTOOutputs = new ArrayList<>();
        List<Moment> moments = repository.getAllMoments();

        for (Moment moment : moments) {
            momentDTOOutputs.add(new MomentDTOOutput(
                    moment.getId(),
                    moment.getTitle(),
                    moment.getDescription(),
                    moment.getEmotion(),
                    moment.getMomentDate(),
                    moment.getCreationDate(),
                    moment.getModificationDate()));

            MomentFormGetView.printMoments(momentDTOOutputs);
        }
    }
    
    /*public MomentDTOOutput getMomentByEmotion() { 
        Moment moment = repository.getMomentByEmotion(Emotion);
        return moment != null ? MomentMapper.toDTO(moment) : null;
    }*/

    public MomentDTOOutput getMomentById(int id) { // Busca un momento por ID//
        Moment moment = repository.getMomentById(id);
        return moment != null ? MomentMapper.toDTO(moment) : null;
    }

    public void updateMoment(MomentDTOInput dto) { // Actualiza un momento existente//
        Moment moment = MomentMapper.toEntity(dto);
        repository.updateMoment(moment);
    }

    public void deleteMoment(int id) { // Elimina un momento//
        repository.deleteMoment(id);
    }

    public List<MomentDTOOutput> getByEmotion(String emotion) {
        throw new UnsupportedOperationException("Unimplemented method 'getByEmotion'");
    }

    public List<MomentDTOOutput> getByMonth(int month) {
        throw new UnsupportedOperationException("Unimplemented method 'getByMonth'");
    }



}