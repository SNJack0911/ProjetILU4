package controleur;

import noyau.Jeu;
import noyau.Pirate;

public class ControleurGetPirateInfo {
    private Jeu jeu;
    private Pirate pirate1;
    private Pirate pirate2;

    public ControleurGetPirateInfo(Jeu jeu) {
        this.jeu = jeu;
        this.pirate1 = jeu.getPirate(0);
        this.pirate2 = jeu.getPirate(1);
    }

    public String getNomPirate(int numero) {
        if (numero == 0){
            return pirate1.getNom();
        } else if (numero == 1) {
            return pirate2.getNom();
        }
        return "Numero de pirates invalide choisir 1 ou 2";
    }

    public int getHpPirate(int numero) {
        if (numero == 0){
            return pirate1.getHP();
        } else if (numero == 1) {
            return pirate2.getHP();
        }
        return -1;
    }

    public int getPpPirate(int numero) {
        if (numero == 0){
            return pirate1.getPP();
        } else if (numero == 1) {
            return pirate2.getPP();
        }
        return -1;
    }
}
