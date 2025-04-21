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
        //TODO Traiter erreur
        return jeuDeCarte.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        //TODO Traiter erreur
        return jeuDeCarte.getCategorie(nomCarte);
    }

    public BasicCategorie getZoneDepotCarte(String nomCarte){
        //TODO Traiter erreur
        return jeuDeCarte.getZoneDepot(nomCarte);
    }
}
