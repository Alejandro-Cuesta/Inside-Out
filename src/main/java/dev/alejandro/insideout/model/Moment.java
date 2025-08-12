package dev.alejandro.insideout.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Moment { //Representa un momento vivido en el Diario y toda la informacion de ese momento//
     //Artributos basicos de un momento//
    private int id;
    private String title;
    private String description;
    private Emotion emotion;
    private LocalDate momentDate;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;

    public Moment() {

    }

    //Getters y Setters//
    public int getId() { return id; }
    public void setId(int id) { this.id = id;}

    public String getTitle() { return title;}
    public void setTitle (String title) { this.title = title; }

    public String getDescription() { return description;}
    public void setDescription (String description) { this.description = description;}

    public Emotion getEmotion() { return emotion;}
    public void setEmotion(Emotion emotion) { this.emotion = emotion;}

    public LocalDate getMomentDate() { return momentDate; }
    public void setMomentDate(LocalDate momentDate) { this.momentDate = momentDate; }

    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public LocalDateTime getModificationDate() { return modificationDate; }
    public void setModificationDate(LocalDateTime modificationDate) { this.modificationDate = modificationDate; }

}
