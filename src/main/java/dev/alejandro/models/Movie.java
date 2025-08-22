package dev.alejandro.models;

import java.time.LocalDateTime;

public class Movie {
    private String imdbId;
    private String title;
    private String url;
    private String image;
    private String[] genres;
    private LocalDateTime addedAt;

    public Movie(String imdbId, String title, String url, String image, String[] genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.url = url;
        this.image = image;
        this.genres = genres;
        this.addedAt = LocalDateTime.now();
    }

    // Getters
    public String getImdbId() { return imdbId; }
    public String getTitle() { return title; }
    public String getUrl() { return url; }
    public String getImage() { return image; }
    public String[] getGenres() { return genres; }
    public LocalDateTime getAddedAt() { return addedAt; }
}