package dev.alejandro.mappers;

import dev.alejandro.dtos.CharacterDTOInput;
import dev.alejandro.dtos.CharacterDTOOutput;
import dev.alejandro.models.Moment;
import dev.alejandro.models.Emotion;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterMapper {

    
    //Convierte un DTO de entrada en un objeto Moment
    public static Moment toEntity(CharacterDTOInput dto) {
        Moment moment = new Moment();

        // ID no se asigna aquí, lo pone la base de datos o lógica de negocio
        moment.setTitle(dto.getTitle());
        moment.setDescription(dto.getDescription());

        // Convertimos el String de emoción a Enum
        try {
            moment.setEmotion(Emotion.valueOf(dto.getEmotion().toUpperCase()));
        } 
            catch (IllegalArgumentException e) {
            throw new RuntimeException("Emoción no válida: " + dto.getEmotion());
            }

        moment.setMomentDate(dto.getMomentDate());

        // Fechas automáticas de creación
        moment.setCreationDate(LocalDateTime.now());
        moment.setModificationDate(null);

        return moment;
    }

        //Convierte un objeto Moment a un DTO de salida//
        public static CharacterDTOOutput toDTO(Moment moment) {
        return new CharacterDTOOutput(
                moment.getId(),
                moment.getTitle(),
                moment.getDescription(),
                moment.getEmotion() != null ? moment.getEmotion().name() : null,
                moment.getMomentDate(),
                moment.getCreationDate(),
                moment.getModificationDate()
        );
        }

        //Método para convertir listas completas//
        public static List<CharacterDTOOutput> toDTOList(List<Moment> moments) {
        return moments.stream()
                .map(CharacterMapper::toDTO)
                .collect(Collectors.toList());
        }
}