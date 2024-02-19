package dev.craftlr.exercice1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        var thread1 = Thread.ofPlatform().start(Main::tacheThread1);
        var thread2 = Thread.ofPlatform().start(Main::tacheThread2);

        thread1.join();
        thread2.join();
    }

    static void tacheThread1() {
        tacheThread(1);
    }

    static void tacheThread2() {
        tacheThread(2);
    }

    private static void tacheThread(int id) {
        System.out.println(STR."Thread \{id} commence à exécuter sa tâche.");
        // Autres opérations...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println(STR."Thread \{id} termine d'exécuter sa tâche.");
    }
}
