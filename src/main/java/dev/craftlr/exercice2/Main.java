package dev.craftlr.exercice2;

public class Main {
    static int variablePartagee = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> incrementer());
        Thread thread2 = new Thread(() -> incrementer());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Valeur finale de la variable partagée : " + variablePartagee);
    }

    static void incrementer() {
        for (int i = 0; i < 10_000; i++) {
            variablePartagee++;
        }
    }
}