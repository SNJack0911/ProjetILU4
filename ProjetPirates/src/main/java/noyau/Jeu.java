package com.ilu4.jeuxpirate.noyau;

import java.util.ArrayList;

public class Jeu {
    private Joueur joueur1;
    private Joueur joueur2;
    private Pioche pioche;
    private int tour;

    public Jeu(){
        initJeu();
    }

    public void initJeu() {
        joueur1 = new Joueur("J1");
        joueur2 = new Joueur("J2");
        pioche = new Pioche(new JeuDeCarte().remplirPioche());
        tour = 0;
        for(int i =0; i<4; i++){
            joueur1.ajouterCarte(pioche.piocher());
            joueur2.ajouterCarte(pioche.piocher());
        }
    }

    private boolean isJeuTermine(){
        return joueur1.getPointPopularite() == 5 || joueur2.getPointPopularite() == 5 ||
               joueur1.getPointVie() == 0 || joueur2.getPointVie() == 0;
    }

    //not == but >=
    private String getGagnant(){
        if (joueur1.getPointPopularite() >= 5 || joueur2.getPointVie() >= 0){
            return joueur1.getNom();
        } else if (joueur2.getPointPopularite() >= 5 || joueur1.getPointVie() >= 0){
            return joueur2.getNom();
        }
        return "Pas de gagnant";
    }

    public ArrayList<Carte> jouerPioche(){
        ArrayList<Carte> cartesLst;
        if(tour %2 == 0){
            cartesLst = piocherInf5(joueur1);
        }else {
            cartesLst = piocherInf5(joueur2);
        }
        return cartesLst;
    }

    //Renvoyer un joueur si les cartes ne sont pas ajouter à la main du joueur
    private ArrayList<Carte> piocherInf5(Joueur joueur){
        Carte carte;
        ArrayList<Carte> cartesLst = new ArrayList<>();
        while (joueur.getNbCarte()<5){
            carte = pioche.piocher();
            joueur.ajouterCarte(carte);
            cartesLst.add(carte);
        }
        return cartesLst;
    }

    public String jouerCarte(String nomCarte){
        ArrayList<Carte> mainPirate;
        Carte carte;
        if(tour %2 == 0){
            mainPirate = joueur1.getMain();
            carte = getCarteMain(nomCarte, mainPirate);
            //Applique effet Carte
            joueur1.suppimerCarteMain(carte);
        } else {
            mainPirate = joueur2.getMain();
            carte = getCarteMain(nomCarte, mainPirate);
            //Applique effet Carte
            joueur1.suppimerCarteMain(carte);
        }
        tour++;
        return getGagnant();
    }

    public Carte getCarteMain(String nomCarte, ArrayList<Carte> mainPirate){
        for (Carte carte : mainPirate) {
            if (carte.getNom().equals(nomCarte)) {return carte;}
        }
        return null;
    }
}
