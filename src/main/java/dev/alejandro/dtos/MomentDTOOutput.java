package dev.alejandro.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import dev.alejandro.models.Emotion;


    public record MomentDTOOutput(int id, String title, String description, Emotion emotion,
                              LocalDate momentDate, LocalDateTime creationDate, LocalDateTime modificationDate) {}
    
