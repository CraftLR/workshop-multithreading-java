package dev.craftlr.exercice3;

public class Main {
    private static final Object verrou = new Object();
    private static int variablePartagee = 0;

    public static void main(String[] args) throws InterruptedException {
        var thread1 = Thread.ofPlatform().start(Main::incrementer);
        var thread2 = Thread.ofPlatform().start(Main::incrementer);

        thread1.join();
        thread2.join();

        System.out.println(STR."Valeur finale de la variable partagée : \{variablePartagee}");
    }

    static void incrementer() {
        for (int i = 0; i < 1_000_000; i++) {
            synchronized (verrou) {
                variablePartagee++;
            }
        }
    }
}
