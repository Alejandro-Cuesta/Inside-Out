package dev.alejandro;

import dev.alejandro.controllers.CharacterController;
import dev.alejandro.repositories.CharacterRepository;
import dev.alejandro.views.ConsoleView;

public class App {
    public static void main(String[] args) {
       
        CharacterRepository repository = new CharacterRepository(); //Crea el repositorio//
        CharacterController controller = new CharacterController(repository);//Crea el controlador y le pasa el repositorio//
        ConsoleView view = new ConsoleView(controller);//Crea la vista y le pasa el controlador//

        view.start(); //Inicia la aplicación//
    }
}