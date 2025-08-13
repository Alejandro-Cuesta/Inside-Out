package dev.alejandro.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CharacterDTOOutput {
    private int id;
    private String title;
    private String description;
    private String emotion;
    private LocalDate momentDate;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public CharacterDTOOutput() {}

    public CharacterDTOOutput(int id, String title, String description, String emotion,
                              LocalDate momentDate, LocalDateTime creationDate, LocalDateTime modificationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.emotion = emotion;
        this.momentDate = momentDate;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }
    //Getters y Setters//
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEmotion() { return emotion; }
    public void setEmotion(String emotion) { this.emotion = emotion; }

    public LocalDate getMomentDate() { return momentDate; }
    public void setMomentDate(LocalDate momentDate) { this.momentDate = momentDate; }

    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public LocalDateTime getModificationDate() { return modificationDate; }
    public void setModificationDate(LocalDateTime modificationDate) { this.modificationDate = modificationDate; }
}