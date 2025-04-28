/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import noyau.Carte;
import noyau.Jeu;

import java.util.ArrayList;

/**
 *
 * @author yannf
 */
public class ControleurPiocherCarte {
    private Jeu jeu;

    public ControleurPiocherCarte(Jeu jeu) {
        this.jeu = jeu;
    }

    public static ArrayList<String> listeCarteToString(ArrayList<Carte> lstCarte){
        ArrayList<String> lstCarteString = new ArrayList<String>();
        for(Carte carte : lstCarte){
            //String[] info = new String[5];
            lstCarteString.add(carte.getNom());
        }
        return lstCarteString;
    }

    public ArrayList<String> piocherCarte() {
        ArrayList<Carte> cartes = jeu.jouerPioche();
        return listeCarteToString(cartes);
    }
}
