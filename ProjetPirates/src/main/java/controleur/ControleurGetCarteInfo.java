package controleur;

import noyau.BasicCategorie;
import noyau.ICategorieCarte;
import noyau.Jeu;
import noyau.JeuDeCarte;

public class ControleurGetCarteInfo {
    private Jeu jeu;
    private JeuDeCarte jeuDeCarte;

    public ControleurGetCarteInfo(Jeu jeu) {
        this.jeu = jeu;
        this.jeuDeCarte = jeu.getJeuDeCarte();
    }

    public String getDecription(String nomCarte){
        //TODO
        return "";
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        //TODO
        return null;
    }

    public BasicCategorie getZoneDepotCarte(String nomCarte){
        //TODO
        return null;
    }
}
