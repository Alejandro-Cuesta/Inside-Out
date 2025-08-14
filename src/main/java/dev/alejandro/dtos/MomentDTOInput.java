package dev.alejandro.dtos;

import java.time.LocalDate;

public class MomentDTOInput {
    private String title;
    private String description;
    private String emotion; //Guardamos el nombre de la emoción como String//
    private LocalDate momentDate;

    public MomentDTOInput() {}

    public MomentDTOInput(String title, String description, String emotion, LocalDate momentDate) {
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
    }
    //Getters y Setters//
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEmotion() { return emotion; }
    public void setEmotion(String emotion) { this.emotion = emotion; }

    public LocalDate getMomentDate() { return momentDate; }
    public void setMomentDate(LocalDate momentDate) { this.momentDate = momentDate; }
}