package dev.alejandro;

import dev.alejandro.controllers.MomentController;
import dev.alejandro.dtos.MomentDTOInput;
import dev.alejandro.dtos.MomentDTOOutput;
import dev.alejandro.models.Emotion;
import dev.alejandro.models.Moment;
import dev.alejandro.repositories.MomentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MomentControllerTest {

    private MomentController controller;
    private MomentRepository repoMock;

    @BeforeEach
    void setUp() {
        repoMock = mock(MomentRepository.class);

        controller = new MomentController() {
            {
                this.repository = repoMock; // Inyectamos el mock en el controlador
            }
        };
    }

    @Test
    void testStoreMoment() {
        MomentDTOInput input = new MomentDTOInput(
                "Parque",
                "Parrillada",
                Emotion.Alegria,
                LocalDate.of(2020, 6, 6),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true
        );

        controller.storeMoment(input);

        verify(repoMock, times(1)).storeMoment(any(Moment.class));
    }

    @Test
    void testListMoments() {
        Moment m = new Moment(
                1,
                "Parque",
                "Parrillada",
                Emotion.Alegria,
                LocalDate.of(2020, 6, 6),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true
        );
        when(repoMock.getAllMoments()).thenReturn(Arrays.asList(m));

        List<MomentDTOOutput> result = controller.listMoments();

        assertEquals(1, result.size());
        assertEquals("Parque", result.get(0).title());
        verify(repoMock, times(1)).getAllMoments();
    }

    @Test
    void testGetMomentById() {
        Moment m = new Moment(
                1,
                "Parque",
                "Parrillada",
                Emotion.Alegria,
                LocalDate.of(2020, 6, 6),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true
        );
        when(repoMock.getMomentById(1)).thenReturn(m);

        MomentDTOOutput result = controller.getMomentById(1);

        assertNotNull(result);
        assertEquals("Parque", result.title());
        verify(repoMock, times(1)).getMomentById(1);
    }

    @Test
    void testUpdateMoment() {
        MomentDTOInput input = new MomentDTOInput(
                "Parque",
                "Caminata",
                Emotion.Alegria,
                LocalDate.of(2020, 6, 6),
                LocalDateTime.now(),
                LocalDateTime.now(),
                true

        );

        controller.updateMoment(input);

        verify(repoMock, times(1)).updateMoment(any(Moment.class));
    }

    @Test
    void testDeleteMoment() {
        controller.deleteMoment(1);

        verify(repoMock, times(1)).deleteMoment(1);
    }

    @Test
    void testGetByEmotion() {
        Moment m1 = new Moment(1, "Parque", "Parrillada", Emotion.Alegria,
                LocalDate.of(2020, 6, 6), LocalDateTime.now(), LocalDateTime.now(), true);
        Moment m2 = new Moment(2, "Playa", "Natación", Emotion.Tristeza,
                LocalDate.of(2020, 7, 7), LocalDateTime.now(), LocalDateTime.now(), false);

        when(repoMock.getAllMoments()).thenReturn(Arrays.asList(m1, m2));

        List<MomentDTOOutput> result = controller.getByEmotion("Alegria");

        assertEquals(1, result.size());
        assertEquals(Emotion.Alegria, result.get(0).emotion());
    }

    @Test
    void testGetByMonth() {
        Moment m1 = new Moment(1, "Parque", "Parrillada", Emotion.Alegria,
                LocalDate.of(2020, 6, 6), LocalDateTime.now(), LocalDateTime.now(), true);
        Moment m2 = new Moment(2, "Playa", "Natación", Emotion.Tristeza,
                LocalDate.of(2020, 7, 7), LocalDateTime.now(), LocalDateTime.now(), false);

        when(repoMock.getAllMoments()).thenReturn(Arrays.asList(m1, m2));

        List<MomentDTOOutput> result = controller.getByMonth(6);

        assertEquals(1, result.size());
        assertEquals(6, result.get(0).momentDate().getMonthValue());
    }
}