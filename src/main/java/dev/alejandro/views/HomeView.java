package dev.alejandro.views;

//import dev.alejandro.controllers.MomentController;
//import dev.alejandro.singletons.MomentControllerSingleton;

public class HomeView extends View {

    //private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void showMenu() {

        int option;
        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Añadir momento");
            System.out.println("2. Ver todos los momentos");
            System.out.println("3. Buscar por emoción");
            System.out.println("4. Buscar por mes");
            System.out.println("5. Eliminar momento");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                option = Integer.parseInt(SCANNER.nextLine());

                if (option == 1) {
                    MomentFormPutView.addMoment();
                }
             
            } catch (NumberFormatException e) {
                System.out.println("Por favor introduce un número válido.");
                option = -1;
            }
        } while (option != 0);
    }
}