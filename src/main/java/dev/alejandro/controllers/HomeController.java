package dev.alejandro.controllers;

import dev.alejandro.views.HomeView;

public class HomeController {
    
    public HomeController() {
        index();
    }

    public void index() {
        HomeView.showMenu();
    }
}
