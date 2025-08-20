package dev.alejandro;

import dev.alejandro.models.Emotion;
import dev.alejandro.models.Moment;
import dev.alejandro.repositories.MomentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MomentRepositoryTest {

    private MomentRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MomentRepository();
    }

    private Moment createTestMoment(int id, String title, String description, Emotion emotion, LocalDate date) {
        Moment m = new Moment();
        m.setId(id);
        m.setTitle(title);
        m.setDescription(description);
        m.setEmotion(emotion);
        m.setMomentDate(date);
        m.setCreationDate(LocalDateTime.now());
        m.setModificationDate(null);
        return m;
    }

   /*  @Test
    void testStoreMoment() {
        Moment moment = createTestMoment(1, "Parque", "Parrillada", Emotion.Alegria, LocalDate.of(2020, 6, 6));
        repository.storeMoment(moment);
        assertEquals(1, repository.getAllMoments().size());
        assertEquals("Parque", repository.getAllMoments().get(0).getTitle());
    }*/

    @Test
    void testGetMomentById() {
        Moment moment = createTestMoment(1, "Parque", "Parrillada", Emotion.Alegria, LocalDate.of(2020, 6, 6));
        repository.storeMoment(moment);
        Moment found = repository.getMomentById(1);
        assertNotNull(found);
        assertEquals("Parque", found.getTitle());
    }

    @Test
    void testUpdateMoment() {
        Moment moment = createTestMoment(1, "Parque", "Parrillada", Emotion.Alegria, LocalDate.of(2020, 6, 6));
        repository.storeMoment(moment);

        moment.setDescription("Caminata con amigos");
        repository.updateMoment(moment);

        Moment updated = repository.getMomentById(1);
        assertEquals("Caminata con amigos", updated.getDescription());
    }

    /*@Test
    void testDeleteMoment() {
        Moment moment = createTestMoment(1, "Parque", "Parrillada", Emotion.Alegria, LocalDate.of(2020, 6, 6));
        repository.storeMoment(moment);

        repository.deleteMoment(1);
        assertNull(repository.getMomentById(1));
        assertTrue(repository.getAllMoments().isEmpty());
    }

    @Test
    void testGetAllMoments() {
        Moment m1 = createTestMoment(1, "Parque", "Parrillada", Emotion.Alegria, LocalDate.of(2020, 6, 6));
        Moment m2 = createTestMoment(2, "Casa", "Lectura", Emotion.Tristeza, LocalDate.of(2020, 7, 7));
        repository.storeMoment(m1);
        repository.storeMoment(m2);

        List<Moment> all = repository.getAllMoments();
        assertEquals(2, all.size());
    }*/
}