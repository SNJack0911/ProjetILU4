package controleur;

import noyau.Jeu;
import noyau.Pirate;

import java.util.ArrayList;

public class ControleurGetPirateInfo {
    private Jeu jeu;
//    private Pirate pirate1;
//    private Pirate pirate2;

    public ControleurGetPirateInfo(Jeu jeu) {
        this.jeu = jeu;
//        this.pirate1 = jeu.getPirate(0);
//        this.pirate2 = jeu.getPirate(1);
    }

    public String getNomPirate(int numero) {
        if (numero == 0 || numero == 1) {
            return jeu.getPirate(numero).getNom();
        }
        return "Numero de pirates invalide choisir 1 ou 2";
    }

    public int getPirateHp(int numero) {
        if (numero == 0 || numero == 1) {
            return jeu.getPirate(numero).getHP();
        }
        return -1;
    }

    public int getPiratePp(int numero) {
        if (numero == 0 || numero == 1) {
            return jeu.getPirate(numero).getPP();
        }
        return -1;
    }

    public ArrayList<String> getPirateMain(int pirateID) {
        if (pirateID == 0 || pirateID == 1){
            return ControleurPiocherCarte.listeCarteToString(jeu.getPirate(pirateID).getMain());
        }
        return null;
    }
}
