package dev.alejandro.dtos;

import java.util.List;

public class MovieDTO {
    private String imdbId;
    private String title;
    private String url;
    private String image;
    private List<String> genres;

    public MovieDTO(String imdbId, String title, String url, String image, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.url = url;
        this.image = image;
        this.genres = genres;
    }

    public String getImdbId() { return imdbId; }
    public String getTitle() { return title; }
    public String getUrl() { return url; }
    public String getImage() { return image; }
    public List<String> getGenres() { return genres; }

    @Override
    public String toString() {
        return title + " (" + imdbId + ") - Géneros: " + genres;
    }

    /* Devuelve una línea en formato CSV de esta película*/
    public String toCSV() {
        String genresJoined = String.join(";", genres); // unimos con ;
        return escapeCsv(imdbId) + "," +
               escapeCsv(title) + "," +
               escapeCsv(url) + "," +
               escapeCsv(image) + "," +
               escapeCsv(genresJoined);
    }

    private String escapeCsv(String value) {
        if (value == null) return "";
        String escaped = value.replace("\"", "\"\"");
        if (escaped.contains(",") || escaped.contains("\n")) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}