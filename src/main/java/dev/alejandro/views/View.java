
package dev.alejandro.views;

import java.util.Scanner;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.mappers.MomentMapper;
import dev.alejandro.repositories.MomentRepository;


    
    public abstract class View {
        protected static Scanner SCANNER = new Scanner(System.in);


        public static void start() {
            // Crear dependencias
            MomentRepository repository = new MomentRepository();
            MomentController controller = new MomentController(repository);
    
            // Lanzar menú principal
            
            HomeView.showMenu();
        }
    }
