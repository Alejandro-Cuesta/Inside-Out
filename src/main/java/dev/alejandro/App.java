package dev.alejandro;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.repositories.MomentRepository;
import dev.alejandro.mappers.MomentMapper;
import dev.alejandro.views.HomeView;

public class App {
    public static void main(String[] args) {
       
        MomentRepository repository = new MomentRepository(); //Crea el repositorio//
        MomentMapper mapper = new MomentMapper();//Crea el Mapper//
        MomentController controller = new MomentController(repository);//Crea el controlador y le pasa el repositorio//
        HomeView view = new HomeView(controller);//Crea la vista y le pasa el controlador//

        view.start(); //Inicia la aplicación//
    }
}