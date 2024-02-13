package dev.craftlr.exercice3;

public class Main {
    private static int variablePartagee = 0;
    private static final Object verrou = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(Main::incrementer);
        Thread thread2 = new Thread(Main::incrementer);

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
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (verrou) {
                variablePartagee++;
            }
        }
    }
}
