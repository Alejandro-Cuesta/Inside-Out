package dev.alejandro.views;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.dtos.MomentDTOInput;
import dev.alejandro.models.Emotion;
import dev.alejandro.singletons.MomentControllerSingleton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MomentFormPutView extends View{

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void addMoment() {
        System.out.print("Título: ");
        String title = SCANNER.nextLine();

        System.out.print("Descripción: ");
        String description = SCANNER.nextLine();

        Emotion emotion = EmotionListView.printEmotionList();

        System.out.print("Fecha del momento (yyyy-MM-dd): ");
        String dateInput = SCANNER.nextLine();
        LocalDate momentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        MomentDTOInput dtoInput = new MomentDTOInput(title, description, emotion, momentDate, null, null);

        CONTROLLER.storeMoment(dtoInput);
        System.out.println("Momento añadido correctamente");

        HomeView.showMenu();
    }

    public void deleteMoment(MomentController controller) {
        System.out.print("ID del momento a eliminar: ");
        int id = Integer.parseInt(SCANNER.nextLine()); // Leemos como int directamente
        controller.deleteMoment(id);
        System.out.println("Momento eliminado correctamente");
    }
}