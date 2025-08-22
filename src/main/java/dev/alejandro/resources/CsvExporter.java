package dev.alejandro.resources;

import dev.alejandro.models.Moment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase encargada de exportar momentos a un archivo CSV.
 */
public class CsvExporter {

    /**
     * Exporta una lista de momentos a un archivo CSV.
     *
     * @param moments lista de Moment
     * @param filePath ruta del archivo donde se guardará el CSV
     */
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

            System.out.println("CSV exportado correctamente en: " + filePath);

        } catch (IOException e) {
            System.err.println("Error al exportar CSV: " + e.getMessage());
        }
    }

    /**
     * Escapa comas y saltos de línea en los textos para que el CSV no se rompa.
     */
    private static String escapeCsv(String value) {
        if (value == null) return "";
        String escaped = value.replace("\"", "\"\"");
        if (escaped.contains(",") || escaped.contains("\n")) {
            return "\"" + escaped + "\"";
        }
        return escaped;
    }
}