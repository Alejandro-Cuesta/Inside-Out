package dev.alejandro.views;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.singletons.MomentControllerSingleton;

public class HomeView extends View {

    private static final MomentController CONTROLLER = MomentControllerSingleton.getInstance();

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
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Prueba de nuevo");
                }
             
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un número válido.");
                option = -1;
            }
        } while (option != 0);
    }
}