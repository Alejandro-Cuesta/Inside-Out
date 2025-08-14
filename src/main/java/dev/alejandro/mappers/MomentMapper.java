package dev.alejandro.mappers;

import dev.alejandro.dtos.MomentDTOInput;
import dev.alejandro.dtos.MomentDTOOutput;
import dev.alejandro.models.Moment;
import dev.alejandro.models.Emotion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MomentMapper {

    
    //Convierte un DTO de entrada en un objeto Moment
    public static Moment toEntity(MomentDTOInput dto) {
        Moment moment = new Moment();
    

        // ID no se asigna aquí, lo pone la base de datos o lógica de negocio
        moment.setTitle(dto.title());
        moment.setDescription(dto.description());

        // Convertimos el String de emoción a Enum
        try {
            moment.setEmotion(Emotion.valueOf(dto.emotion().toUpperCase()));
        } 
            catch (IllegalArgumentException e) {
            throw new RuntimeException("Emoción no válida: " + dto.emotion());
            }

        moment.setMomentDate(dto.momentDate());

        // Fechas automáticas de creación
        moment.setCreationDate(LocalDateTime.now());
        moment.setModificationDate(null);

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
                    moment.getModificationDate());
        }

        //Método para convertir listas completas//
        public static List<MomentDTOOutput> toDTOList(List<Moment> moments) {
        return moments.stream()
                .map(MomentMapper::toDTO)
                .collect(Collectors.toList());
        }
}