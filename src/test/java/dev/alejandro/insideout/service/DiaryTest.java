
package dev.alejandro.insideout.service;

import dev.alejandro.insideout.model.Emotion;
import dev.alejandro.insideout.model.Moment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Tests unitarios para la clase Diary//
public class DiaryTest {

    private Diary diary;

    @BeforeEach
    void setUp() {
        diary = new Diary();
    }

    @Test
    void testAddMomentAndGetAllMoments() { //añadir un momento//
    Moment moment = new Moment();
    moment.setId(1);
    moment.setTitle("Un día en el parque de atracciones");
    moment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus.");
    moment.setEmotion(Emotion.ALEGRIA);
    moment.setMomentDate(LocalDate.of(2024, 5, 1));
    moment.setCreationDate(LocalDateTime.now());
    moment.setModificationDate(LocalDateTime.now());

    diary.addMoment(moment);

    List<Moment> moments = diary.getAllMoments();

    assertNotNull(moments, "La lista no debería ser nula");
    assertEquals(1, moments.size(), "Debería haber un momento guardado");
    assertEquals("Un día en el parque de atracciones", moments.get(0).getTitle(), "El título debería coincidir");
    }

    @Test
    public void testRemoveMomentById() {
    Moment moment = new Moment();
    moment.setId(1);
    moment.setTitle("Un dia en el parque de atracciones");
    moment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus.");
    moment.setEmotion(Emotion.ALEGRIA);
    moment.setMomentDate(LocalDate.of(2024, 5, 1));
    moment.setCreationDate(LocalDateTime.now());
    moment.setModificationDate(LocalDateTime.now());

    diary.addMoment(moment);

    boolean removed = diary.removeMomentById(1);

    assertTrue(removed, "El momento debería eliminarse correctamente");
    assertTrue(diary.getAllMoments().isEmpty(), "La lista de momentos debería estar vacía después de eliminar");
    }


}