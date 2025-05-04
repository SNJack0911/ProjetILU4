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

    public String getDescription(String nomCarte){
        return jeuDeCarte.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        return jeuDeCarte.getCategorie(nomCarte);
    }

    public BasicCategorie getZoneDepotCarte(String nomCarte){
        return jeuDeCarte.getZoneDepot(nomCarte);
    }

    public int getCarteID(String nomCarte) {
        return jeuDeCarte.getCarteID(nomCarte);
    }
}
