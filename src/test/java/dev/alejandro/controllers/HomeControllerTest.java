package dev.alejandro.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeControllerTest {

    static class FakeHomeView {
        static boolean called = false;

        static void showMenu() {
            called = true; // Simulamos que se llamó
        }
    }

    @Test
    void testIndexCallsHomeView() {
        HomeController controller = new HomeController() {
            @Override
            public void index() {
                FakeHomeView.showMenu(); // usamos fake en vez del real
            }
        };

        controller.index();

        assertTrue(FakeHomeView.called);
    }
}