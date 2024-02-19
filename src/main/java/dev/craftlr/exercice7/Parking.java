package dev.craftlr.exercice7;

import java.util.concurrent.Semaphore;

public class Parking {
    private static final int NOMBRE_PLACES = 5;
    private static final Semaphore semaphore = new Semaphore(NOMBRE_PLACES, false);

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(new Voiture(i)).start();
        }
    }

    static class Voiture implements Runnable {
        private final int id;

        public Voiture(int id) {
            this.id = id;
        }

        public void run() {
            try {
                System.out.println(STR."Voiture \{id} cherche une place.");
                semaphore.acquire();
                System.out.println(STR."Voiture \{id} se gare.");
                // Simuler le temps de stationnement
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println(STR."Voiture \{id} quitte le parking.");
                semaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
