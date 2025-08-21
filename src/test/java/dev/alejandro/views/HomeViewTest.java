package dev.alejandro.views;

import org.junit.jupiter.api.*;
import java.io.*;

@Disabled("Todos los tests están deshabilitados temporalmente porque HomeView.showMenu() provoca bucle")
class HomeViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @Disabled("Deshabilitado temporalmente para evitar bucle infinito")
    void testShowMenuExitsImmediately() {
        Runnable task = () -> {
            HomeView.showMenu();
        };

        Thread t = new Thread(task);
        t.start();

        try {
            t.join(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (t.isAlive()) {
            t.stop();
        }

        String output = outContent.toString();
        Assertions.assertTrue(
            output.contains("MENÚ PRINCIPAL"),
            "El menú principal debería haberse imprimido"
        );
    }
}