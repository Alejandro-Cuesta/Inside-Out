package dev.alejandro.views;

import dev.alejandro.controllers.MovieController;
import dev.alejandro.controllers.MomentController;
import dev.alejandro.dtos.MovieDTO;
import dev.alejandro.singletons.MomentControllerSingleton;
import dev.alejandro.resources.CsvExporter;
import dev.alejandro.services.MovieService;

import java.util.List;
import java.util.Scanner;
import java.nio.file.Paths;

public class HomeView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    private static final MovieController MOVIE_CONTROLLER = new MovieController();
    private static final MovieService MOVIE_SERVICE = new MovieService();
    private static final Scanner SCANNER = new Scanner(System.in); // ✅ definido aquí

    public static void showMenu() {
        int option;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Añadir momento");
            System.out.println("2. Ver todos los momentos");
            System.out.println("3. Buscar por emoción");
            System.out.println("4. Buscar por mes");
            System.out.println("5. Eliminar momento");
            System.out.println("6. Ver momentos buenos");
            System.out.println("7. Ver momentos malos");
            System.out.println("8. Exportar momentos a CSV");
            System.out.println("9. Añadir película por IMDb");
            System.out.println("10. Ver películas");
            System.out.println("11. Filtrar películas por género");
            System.out.println("12. Exportar películas a CSV");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                option = Integer.parseInt(SCANNER.nextLine());

                switch (option) {
                    case 1:
                        MomentFormPutView.addMoment();
                        break;
                    case 2:
                        new MomentFormGetView().showAllMoments();
                        break;
                    case 3:
                        new MomentFormGetView().searchByEmotion();
                        break;
                    case 4:
                        new MomentFormGetView().searchByMonth();
                        break;
                    case 5:
                        new MomentFormPutView().deleteMoment(CONTROLLER);
                        break;
                    case 6:
                        new MomentFormGetView().showFilteredMoments(true);
                        break;
                    case 7:
                        new MomentFormGetView().showFilteredMoments(false);
                        break;
                    case 8:
                        String rutaCSV = Paths.get("src", "main", "resources", "momentos.csv").toString();
                        CsvExporter.exportToCSV(CONTROLLER.getAllMoments(), rutaCSV);
                        break;
                    case 9:
                        System.out.print("Introduce IMDB ID: ");
                        String imdbId = SCANNER.nextLine();
                        MovieDTO movie = MOVIE_SERVICE.getMovieByImdbId(imdbId);
                        if (movie != null) {
                            MOVIE_CONTROLLER.addMovie(movie);
                            System.out.println("Película añadida: " + movie.getTitle());
                        }
                        break;
                    case 10:
                        List<MovieDTO> movies = MOVIE_CONTROLLER.listMovies();
                        movies.forEach(System.out::println);
                        break;
                    case 11:
                        System.out.print("Introduce género: ");
                        String genre = SCANNER.nextLine();
                        List<MovieDTO> filtered = MOVIE_CONTROLLER.getMoviesByGenre(genre);
                        filtered.forEach(System.out::println);
                        break;
                    case 12:
                        String rutaMoviesCSV = Paths.get("src","main","resources","peliculas.csv").toString();
                        CsvExporter.exportMoviesToCSV(MOVIE_CONTROLLER.listMovies(), rutaMoviesCSV);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Prueba de nuevo");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un número válido.");
                option = -1;
            }
        } while (option != 0);
    }
}