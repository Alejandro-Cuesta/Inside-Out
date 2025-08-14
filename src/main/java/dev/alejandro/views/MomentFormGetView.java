package dev.alejandro.views;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.dtos.MomentDTOOutput;
import java.util.List;
import java.util.Scanner;

public class MomentFormGetView extends View{

    private final MomentController controller;

    public MomentFormGetView(MomentController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showAllMoments() {
        List<MomentDTOOutput> moments = controller.getAllMoments();
        printMoments(moments);
    }

    public void searchByEmotion() {
        System.out.print("Introduce la emoción: ");
        String emotion = scanner.nextLine();
        List<MomentDTOOutput> moments = controller.getByEmotion(emotion);
        printMoments(moments);
    }

    public void searchByMonth() {
        System.out.print("Introduce el número de mes (1-12): ");
        int month;
        try {
            month = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mes inválido.");
            return;
        }
        List<MomentDTOOutput> moments = controller.getByMonth(month);
        printMoments(moments);
    }

    public static void printMoments(List<MomentDTOOutput> moments) {
        if (moments.isEmpty()) {
            System.out.println("No hay momentos para mostrar.");
        } else {
            for (MomentDTOOutput dto : moments) {
                System.out.println(dto);
            }
        }
    }
}