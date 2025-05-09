/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import noyau.Jeu;

/**
 *
 * @author yannf
 */
//PAS NECESSAIRE
    //TODO Transformer en creer nouvelle partie
public class ControleurNouvellePartie {
    private Jeu jeu;

    public ControleurNouvellePartie(Jeu jeu) {
        this.jeu = jeu;
    }

    public int getTour(){return jeu.getTour();}
    
    public void incrementerTour(){
        jeu.incrementerTour();
    }
    
    /*public void setNuit(Boolean isNuit){
        jeu.setNuit(isNuit);
    }*/

    public boolean isNuit(){return jeu.isNuit();}

}
