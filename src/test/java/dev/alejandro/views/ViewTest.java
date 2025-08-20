package dev.alejandro.views;

import dev.alejandro.dtos.MomentDTOOutput;
import dev.alejandro.models.Emotion;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {

 
    @Test
    void testHomeViewInitialization() {
        // HomeView tiene solo métodos estáticos
        Class<?> clazz = HomeView.class;
        assertEquals("HomeView", clazz.getSimpleName());
    }

  
    @Test
    void testEmotionListViewPrintEmotionList() {
        Scanner originalScanner = EmotionListView.SCANNER;
        try {
            EmotionListView.SCANNER = new Scanner("1\n");
            Emotion emotion = EmotionListView.printEmotionList();
            assertEquals(Emotion.values()[0], emotion);
        } finally {
            EmotionListView.SCANNER = originalScanner;
        }
    }

    
    @Test
    void testMomentFormGetViewShowAll() {
        MomentFormGetView view = new MomentFormGetView() {
            @Override
            public void showAllMoments() {
                printMoments(List.of(
                        new MomentDTOOutput(
                                1,
                                "titulo",
                                "desc",
                                Emotion.Alegria,
                                LocalDate.of(2025, 1, 1),
                                LocalDateTime.of(2025, 1, 1, 12, 0),
                                LocalDateTime.of(2025, 1, 1, 12, 0)
                        )
                ));
            }
        };
        view.showAllMoments();
    }

    @Test
    void testMomentFormGetViewSearchByEmotion() {
        MomentFormGetView view = new MomentFormGetView() {
            @Override
            public void searchByEmotion() {
                printMoments(List.of(
                        new MomentDTOOutput(
                                2,
                                "titulo2",
                                "desc2",
                                Emotion.Tristeza,
                                LocalDate.of(2025, 2, 2),
                                LocalDateTime.of(2025, 2, 2, 12, 0),
                                LocalDateTime.of(2025, 2, 2, 12, 0)
                        )
                ));
            }
        };
        view.searchByEmotion();
    }

  /*   @Test
    void testMomentFormGetViewSearchByMonth() {
        MomentFormGetView view = new MomentFormGetView() {
            @Override
            public void searchByMonth() {
                printMoments(List.of(
                        new MomentDTOOutput(
                                3,
                                "titulo3",
                                "desc3",
                                Emotion.Ira,
                                LocalDate.of(2025, 3, 3),
                                LocalDateTime.of(2025, 3, 3, 12, 0),
                                LocalDateTime.of(2025, 3, 3, 12, 0)
                        )
                ));
            }
        };
        view.searchByMonth();
    }
*/
  
    @Test
    void testMomentFormPutViewAddMoment() {
        Scanner originalScanner = MomentFormPutView.SCANNER;
        try {
            String simulatedInput = "TituloTest\nDescripcionTest\n1\n2025-01-01\n";
            MomentFormPutView.SCANNER = new Scanner(simulatedInput);
            MomentFormPutView.addMoment();
        } finally {
            MomentFormPutView.SCANNER = originalScanner;
        }
    }

   /*  @Test
    void testMomentFormPutViewDeleteMoment() {
        MomentFormPutView view = new MomentFormPutView();
        view.deleteMoment(new dev.alejandro.controllers.MomentController() {
            @Override
            public void deleteMoment(int id) {
                // Mock: no hace nada real
                System.out.println("Mock delete invoked with id: " + id);
            }
        });
    }*/

    
    @Test
    void testViewInitialization() {
        Class<?> clazz = View.class;
        assertEquals("View", clazz.getSimpleName());
    }
}