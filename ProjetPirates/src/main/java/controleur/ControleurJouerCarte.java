/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import noyau.Jeu;

import java.util.List;

/**
 *
 * @author yannf
 */
public class ControleurJouerCarte {
    private Jeu jeu; //Mettre final ?

    public ControleurJouerCarte(Jeu jeu) {
        this.jeu = jeu;
    }

    public List<String> jouerCarte(String nomCarte) {
        return jeu.jouerCarte(nomCarte);
    }
}
