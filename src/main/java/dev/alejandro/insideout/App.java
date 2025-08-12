package dev.alejandro.insideout;

import dev.alejandro.insideout.service.Diary;
import dev.alejandro.insideout.consol.Consol;

public class App {
    public static void main(String[] args) {
        Diary diary = new Diary();
        Consol consol = new Consol(diary);
        consol.start();
    }
}