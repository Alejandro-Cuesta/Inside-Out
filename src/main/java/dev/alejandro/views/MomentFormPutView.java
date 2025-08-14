package dev.alejandro.views;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.dtos.MomentDTOInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MomentFormPutView {

    private final MomentController controller;
    private final Scanner scanner;

    public MomentFormPutView(MomentController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public static void addMoment() {
        System.out.print("Título: ");
        String title = scanner.nextLine();

        System.out.print("Descripción: ");
        String description = scanner.nextLine();

        System.out.print("Emoción: ");
        String emotion = scanner.nextLine();

        System.out.print("Fecha del momento (yyyy-MM-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate momentDate = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        MomentDTOInput dto = new MomentDTOInput();
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setEmotion(emotion);
        dto.setMomentDate(momentDate);

        controller.addMoment(dto);

        System.out.println("Momento añadido correctamente");
    }

    public void deleteMoment() {
        System.out.print("ID del momento a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine()); // Leemos como int directamente
        controller.deleteMoment(id);
        System.out.println("Momento eliminado correctamente");
    }
}