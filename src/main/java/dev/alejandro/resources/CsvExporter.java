package dev.alejandro.resources;

import dev.alejandro.models.Moment;
import dev.alejandro.dtos.MovieDTO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class CsvExporter {

    /*Exporta una lista de momentos a un archivo CSV*/
     
    public static void exportToCSV(List<Moment> moments, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Cabecera
            writer.append("ID,Título,Descripción,Emoción,EsBueno,Fecha\n");

            // Filas con datos
            for (Moment m : moments) {
                writer.append(String.valueOf(m.getId())).append(",");
                writer.append(escapeCsv(m.getTitle())).append(",");
                writer.append(escapeCsv(m.getDescription())).append(",");
                writer.append(m.getEmotion().toString()).append(",");
                writer.append(String.valueOf(m.isGood())).append(",");
                writer.append(m.getMomentDate().toString()).append("\n");
            }

            System.out.println("CSV de momentos exportado correctamente en: " + filePath);

        } catch (IOException e) {
            System.err.println("Error al exportar CSV de momentos: " + e.getMessage());
        }
    }

    /* Exporta una lista de películas a un archivo CSV*/
    public static void exportMoviesToCSV(List<MovieDTO> movies, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Cabecera
            writer.append("IMDB ID,Título,URL,Imagen,Géneros\n");

            // Filas con datos
            for (MovieDTO movie : movies) {
                writer.append(movie.toCSV()).append("\n");
            }

            System.out.println("CSV de películas exportado correctamente en: " + filePath);

        } catch (IOException e) {
            System.err.println("Error al exportar CSV de películas: " + e.getMessage());
        }
    }

    private static String escapeCsv(String value) {
        if (value == null) return "";
        String escaped = value.replace("\"", "\"\"");
        if (escaped.contains(",") || escaped.contains("\n")) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}