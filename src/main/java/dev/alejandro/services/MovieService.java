package dev.alejandro.services;

import dev.alejandro.dtos.MovieDTO;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Arrays;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieService {

    private final String apiUrl = "https://freepublicapis.com/free-movie-api?imdbId=";

    public MovieDTO getMovieByImdbId(String imdbId) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl + imdbId))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                                                      .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();
            JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

            String title = jsonObject.get("title").getAsString();
            String url = jsonObject.get("url").getAsString();
            String image = jsonObject.get("image").getAsString();
            String[] genresArray = jsonObject.get("genres").getAsString().split(",");
            
            return new MovieDTO(imdbId, title, url, image, Arrays.asList(genresArray));

        } catch (Exception e) {
            System.err.println("Error al obtener la película: " + e.getMessage());
            return null;
        }
    }
}