package dev.alejandro.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import dev.alejandro.models.Emotion;


    public record MomentDTOOutput(int id, String title, String description, Emotion emotion,
                              LocalDate momentDate, LocalDateTime creationDate, LocalDateTime modificationDate) {
       /*  this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;*/
    }
