package dev.craftlr.exercice8;

import java.util.concurrent.CountDownLatch;

public class Main {
    private static final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        var threadDeChargement = Thread.ofPlatform().start(Main::chargerDonnees);
        var threadDeTraitement = Thread.ofPlatform().start(Main::traiterDonnees);

        threadDeChargement.join();
        threadDeTraitement.join();
    }

    static void chargerDonnees() {
        System.out.println("Chargement des données...");
        // Simuler le temps de chargement
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Les données sont chargées.");
        latch.countDown(); // Signaler que les données sont chargées
    }

    static void traiterDonnees() {
        try {
            System.out.println("En attente des données...");
            latch.await(); // Attendre que les données soient chargées
            System.out.println("Traitement des données.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
