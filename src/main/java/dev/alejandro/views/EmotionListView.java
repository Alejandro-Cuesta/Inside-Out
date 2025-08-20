package dev.alejandro.views;

import dev.alejandro.models.Emotion;

public class EmotionListView extends View {
    public static Emotion printEmotionList() {
        
int orderNum = 1;

System.out.println("Seleccionar una emocion");

for (Emotion emotion : Emotion.values()) {
            System.out.println(orderNum + "." + emotion);
            orderNum++;
        }

        System.out.println("Ingrese su opcion:");

        int option = SCANNER.nextInt();
        SCANNER.nextLine();

        if (option < 1 || option > Emotion.values().length) {
           System.out.println("Numero de emocion incorrecto! Prueba de nuevo");
           return printEmotionList(); 
        }

        Emotion emotion = Emotion.values() [option - 1];
        return emotion;
    }
}
