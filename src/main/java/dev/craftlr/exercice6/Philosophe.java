package dev.craftlr.exercice6;

import java.util.Random;

public class Philosophe implements Runnable {
    private final int id;
    private final Fourchette gauche;
    private final Fourchette droite;

    public Philosophe(int id, Fourchette gauche, Fourchette droite) {
        this.id = id;
        this.gauche = gauche;
        this.droite = droite;
    }

    @Override
    public void run() {
        while (true) {
            penser();
            prendreFourchettes();
            manger();
            deposerFourchettes();
        }
    }

    private void penser() {
        System.out.println("Philosophe " + id + " pense.");
        attendre();
    }

    private synchronized void prendreFourchettes() {
        System.out.println("Philosophe " + id + " souhaite prendre les deux fourchettes.");
        gauche.prendre();
        droite.prendre();
        System.out.println("Philosophe " + id + " a pris les deux fourchettes.");
    }

    private void manger() {
        System.out.println("Philosophe " + id + " mange.");
        attendre();
    }

    private synchronized void deposerFourchettes() {
        gauche.poser();
        droite.poser();
        System.out.println("Philosophe " + id + " a reposé les deux fourchettes.");
    }

    private void attendre() {
        try {
            Thread.sleep(new Random().nextInt(1000, 2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}