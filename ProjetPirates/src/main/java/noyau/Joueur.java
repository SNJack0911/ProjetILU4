package com.ilu4.jeuxpirate.noyau;

public class Joueur {
    private String nom;
    private int pointVie;
    private int pointPopularite;

    public Joueur(String nom){
        this.nom = nom;
        pointPopularite = 0;
        pointVie = 5;
    }

    public String getNom() {
        return null;
    }

    public int getPointVie() {return pointVie;}

    public int getPointPopularite() {return pointPopularite;}

    public void ajouterCarte(Carte piocher) {
    }
}
