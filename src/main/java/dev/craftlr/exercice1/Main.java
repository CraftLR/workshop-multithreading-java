package dev.craftlr.exercice1;

public class Main {

    public static void main(String[] args) {
        try {
            Thread thread1 = new Thread(Main::tacheThread1);
            Thread thread2 = new Thread(Main::tacheThread2);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaure l'état d'interruption
            System.out.println("Thread interrompu.");
        }
    }

    static void tacheThread1(){
        System.out.println("Thread 1 commence à exécuter sa tâche.");
        // Autres opérations...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread 1 termine d'exécuter sa tâche.");
    }

    static void tacheThread2(){
        System.out.println("Thread 2 commence à exécuter sa tâche.");
        // Autres opérations...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread 2 termine d'exécuter sa tâche.");
    }
}
