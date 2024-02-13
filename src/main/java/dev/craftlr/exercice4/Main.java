package dev.craftlr.exercice4;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final Queue<String> queue = new LinkedList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread producteur = new Thread(Main::produire);
        Thread consommateur = new Thread(Main::consommer);

        producteur.start();
        consommateur.start();
    }

    static void produire() {
        while (true) { // Boucle infinie pour produire des tâches continuellement
            synchronized (lock) {
                while (queue.size() >= 5) { // Limite la taille de la file pour éviter surcharge
                    try {
                        System.out.println("File pleine. Producteur en attente...");
                        lock.wait(); // Attente jusqu'à ce que la consommation libère de l'espace
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                String tache = "Tâche " + System.currentTimeMillis();
                queue.add(tache);
                System.out.println("Producteur a produit : " + tache);
                lock.notifyAll(); // Réveille les threads consommateurs en attente
            }

            // Simuler un délai de production
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    
    static void consommer() {
        while (true) { // Boucle infinie pour consommer des tâches continuellement
            synchronized (lock) {
                while (queue.isEmpty()) { // Vérifie si la file est vide
                    try {
                        System.out.println("Consommateur en attente de tâches...");
                        lock.wait(); // Attend qu'une tâche soit disponible
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                String tache = queue.poll(); // Récupère et supprime la tâche en tête de file
                System.out.println("Consommateur a traité : " + tache);
                lock.notifyAll(); // Notifie les producteurs en attente
            }

            // Simuler un délai de consommation
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
    
}

