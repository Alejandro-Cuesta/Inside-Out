
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
    public void testRemoveMomentById() { //eliminar un momento por Id//
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

    @Test
    void testFilterByEmotion() { //filtrar momento por Emocion//
    Moment moment1 = new Moment();
    moment1.setId(1);
    moment1.setTitle("Un día en el parque de atracciones");
    moment1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus sed eros vel massa scelerisque convallis interdum ut purus.");
    moment1.setEmotion(Emotion.ALEGRIA);
    moment1.setMomentDate(LocalDate.of(2024, 5, 1));
    moment1.setCreationDate(LocalDateTime.now());
    moment1.setModificationDate(LocalDateTime.now());

    Moment moment2 = new Moment();
    moment2.setId(2);
    moment2.setTitle("Una tarde en el cementerio");
    moment2.setDescription("Pensando en los que ya no estan");
    moment2.setEmotion(Emotion.TRISTEZA);
    moment2.setMomentDate(LocalDate.of(2024, 4, 17));
    moment2.setCreationDate(LocalDateTime.now());
    moment2.setModificationDate(LocalDateTime.now());

    diary.addMoment(moment1);
    diary.addMoment(moment2);

    List<Moment> filtered = diary.filterByEmotion(Emotion.ALEGRIA);

    assertNotNull(filtered, "La lista filtrada no debería ser nula");
    assertEquals(1, filtered.size(), "Debería haber un solo momento con la emoción ALEGRIA");
    assertEquals("Un día en el parque de atracciones", filtered.get(0).getTitle(), "El título debería coincidir con el momento feliz");
    }

}