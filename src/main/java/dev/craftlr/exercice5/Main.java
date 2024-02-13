package dev.craftlr.exercice5;

public class Main {
    private static final Object ressource1 = new Object();
    private static final Object ressource2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (ressource1) {
                System.out.println("Thread 1: Verrouillé ressource 1");
                try {
                    Thread.sleep(100); // Simuler le travail
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (ressource2) {
                    System.out.println("Thread 1: Verrouillé ressource 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (ressource2) {
                System.out.println("Thread 2: Verrouillé ressource 2");
                try {
                    Thread.sleep(100); // Simuler le travail
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (ressource1) {
                    System.out.println("Thread 2: Verrouillé ressource 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
