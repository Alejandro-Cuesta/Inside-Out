package dev.alejandro;

import dev.alejandro.models.Emotion;
import dev.alejandro.models.Moment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MomentAndEmotionTest {

    @Test
    void testEmotionValues() {
        // Cubrir todos los enums
        for (Emotion e : Emotion.values()) {
            assertNotNull(e.name());
        }
        assertEquals(Emotion.Alegria, Emotion.valueOf("Alegria"));
    }

    @Test
    void testMomentConstructorAndGetters() {
        LocalDate fecha = LocalDate.of(2023, 5, 20);
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime updated = LocalDateTime.now();

        Moment m = new Moment(
        1,
        "Título de prueba",
        "Descripción de prueba",
        Emotion.Alegria,
        fecha,
        created,
        updated,
        true // o false, según lo que quieras probar
        );

        assertEquals(1, m.getId());
        assertEquals("Título de prueba", m.getTitle());
        assertEquals("Descripción de prueba", m.getDescription());
        assertEquals(Emotion.Alegria, m.getEmotion());
        assertEquals(fecha, m.getMomentDate());
        assertEquals(created, m.getCreationDate());
        assertEquals(updated, m.getModificationDate());
    }

    @Test
    void testMomentSetters() {
        Moment m = new Moment();
        m.setId(5);
        m.setTitle("Nuevo título");
        m.setDescription("Nueva descripción");
        m.setEmotion(Emotion.Tristeza);
        LocalDate fecha = LocalDate.of(2022, 1, 1);
        m.setMomentDate(fecha);

        assertEquals(5, m.getId());
        assertEquals("Nuevo título", m.getTitle());
        assertEquals("Nueva descripción", m.getDescription());
        assertEquals(Emotion.Tristeza, m.getEmotion());
        assertEquals(fecha, m.getMomentDate());
    }
}