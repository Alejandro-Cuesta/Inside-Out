package dev.alejandro.mappers;

import dev.alejandro.dtos.MomentDTOInput;
import dev.alejandro.dtos.MomentDTOOutput;
import dev.alejandro.models.Moment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MomentMapper {

    
    //Convierte un DTO de entrada en un objeto Moment
    public static Moment toEntity(MomentDTOInput dto) {
        Moment moment = new Moment();
    

       
        moment.setTitle(dto.title());
        moment.setDescription(dto.description());
        moment.setEmotion(dto.emotion());
        moment.setMomentDate(dto.momentDate());

        moment.setCreationDate(LocalDateTime.now());
        moment.setModificationDate(null);
       // Decidir si es bueno o malo según la emoción
        switch (dto.emotion()) {
            case Alegria -> moment.setGood(true);   // emociones positivas
            case Tristeza, Ira, Asco -> moment.setGood(false);  // emociones negativas
            default -> moment.setGood(true); // por defecto bueno
        }

       

        return moment;
    }

        //Convierte un objeto Moment a un DTO de salida//
        public static MomentDTOOutput toDTO(Moment moment) {
        return new MomentDTOOutput(
                moment.getId(),
                moment.getTitle(),
                moment.getDescription(),
                moment.getEmotion(),
                moment.getMomentDate(),
                moment.getCreationDate(),
                moment.getModificationDate(),
                moment.isGood());
        }

        //Método para convertir listas completas//
        public static List<MomentDTOOutput> toDTOList(List<Moment> moments) {
        return moments.stream()
                .map(MomentMapper::toDTO)
                .collect(Collectors.toList());
        }
}