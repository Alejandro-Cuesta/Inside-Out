package dev.alejandro.views;

import org.junit.jupiter.api.*;
import java.io.*;

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
    void testShowMenuPrintsHeader() {
        Thread menuThread = new Thread(HomeView::showMenu);
        menuThread.setDaemon(true); // Hilo de fondo que no bloquea la terminación del test
        menuThread.start();

        try {
            menuThread.join(500); // Espera máximo 500ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String output = outContent.toString();
        Assertions.assertTrue(output.contains("MENÚ PRINCIPAL"),
                "El menú principal debería haberse imprimido");
    }
}