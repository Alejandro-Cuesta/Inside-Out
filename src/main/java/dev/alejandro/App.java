package dev.alejandro;

import dev.alejandro.views.ConsoleView;
import dev.alejandro.controllers.CharacterController;
import dev.alejandro.repositories.CharacterRepository;
import dev.alejandro.singletons.CharacterRepositorySingleton;

public class App {
    public static void main(String[] args) {
        CharacterRepository repository = CharacterRepositorySingleton.getInstance();
        CharacterController controller = new CharacterController(repository);
        ConsoleView view = new ConsoleView(controller);

        view.start();
    }
}