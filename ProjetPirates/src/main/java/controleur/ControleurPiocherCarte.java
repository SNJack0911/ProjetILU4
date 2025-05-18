/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import noyau.Carte;
import noyau.Jeu;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannf
 */
public class ControleurPiocherCarte {
    private Jeu jeu;

    public ControleurPiocherCarte(Jeu jeu) {
        this.jeu = jeu;
    }

    public static List<String> listeCarteToString(List<Carte> list){
        ArrayList<String> lstCarteString = new ArrayList<>(); // ??
        for(Carte carte : list){
            lstCarteString.add(carte.getNom());
        }
        return lstCarteString;
    }

    public List<String> piocherCarte() {
        List<Carte> cartes = jeu.jouerPioche();
        return listeCarteToString(cartes);
    }
}
