package dev.alejandro;

import dev.alejandro.db.Database;
import dev.alejandro.models.Emotion;
import dev.alejandro.models.Moment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database db;

    @BeforeEach
    void setUp() {
        db = new Database();
    }

    private Moment createTestMoment(int id, String title, String description, Emotion emotion) {
        Moment m = new Moment();
        m.setId(id);
        m.setTitle(title);
        m.setDescription(description);
        m.setEmotion(emotion);
        m.setMomentDate(LocalDate.now());
        m.setCreationDate(LocalDateTime.now());
        m.setModificationDate(null);
        return m;
    }

    @Test
    void testStoreAndGetAllMoments() {
        Moment moment = createTestMoment(1, "Titulo", "Descripcion", Emotion.Alegria);
        db.store(moment);

        List<Moment> moments = db.getAllMoments();
        assertEquals(1, moments.size());
    }

   /*  @Test
    void testDeleteMoment() {
        Moment moment = createTestMoment(1, "Titulo", "Descripcion", Emotion.Alegria);
        db.store(moment);

        db.deleteMoment(0);
        assertEquals(0, db.getAllMoments().size());
    }*/
}