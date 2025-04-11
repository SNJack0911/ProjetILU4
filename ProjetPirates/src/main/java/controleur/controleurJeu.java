package controleur;

import noyau.Carte;
import noyau.Jeu;

import java.util.ArrayList;

public class controleurJeu {
    Jeu jeu =  new Jeu();


    public void controleurCreerJeu(){
        jeu = new Jeu();
    }

    public ArrayList<String> controleurJouerPioche(){
        ArrayList <Carte> cartesAjoute= jeu.jouerPioche();
        return listeCarteToString(cartesAjoute);
    }

    private ArrayList<String> listeCarteToString(ArrayList<Carte> lstCarte){
        ArrayList<String> lstCarteString = new ArrayList<String>();
        for(Carte carte : lstCarte){
            lstCarteString.add(carte.getNom());
        }
        return lstCarteString;
    }

    private String controleurJouerCarte(String nomCarte){
        return jeu.jouerCarte(nomCarte);
    }
}
