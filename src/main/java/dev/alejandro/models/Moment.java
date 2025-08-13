package dev.alejandro.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public Moment(int id, String title, String description, Emotion emotion,
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


     @Override
    public String toString() {
        return "Moment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", emotion=" + emotion +
                ", momentDate=" + momentDate +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                '}';
    }
}
