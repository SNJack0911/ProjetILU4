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
        //TODO
        return "";
    }

    public int getHpPirate(int numero) {
        //TODO
        return -1;
    }

    public int getPpPirate(int numero) {
        //TODO
        return -1;
    }
}
