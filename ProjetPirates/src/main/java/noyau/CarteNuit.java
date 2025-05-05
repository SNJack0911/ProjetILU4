package noyau;

import java.util.ArrayList;
import java.util.List;

public class CarteNuit extends CarteAttaqueLamda{
    private String statNuit;

    public CarteNuit(String nom, int carteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot, IEffet effetPPJ, IEffet effetHPJ, IEffet effetPPA, IEffet effetHPA, String statNuit) {
        super(nom, carteID, description, categorie, zoneDepot, effetPPJ, effetHPJ, effetPPA, effetHPA);
        this.statNuit = statNuit;
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        int newPPJ = 0;
        int newHPJ = 0;
        int newPPA = 0;
        int newHPA = 0;

        if(statNuit.equals("PP")){
            if (effetPPJ != null) newPPJ = effetPPJ.newValue(joueur, jeu)+1;
            if (effetPPA != null) newPPA = effetPPA.newValue(adversaire, jeu)+1;
        } else if (statNuit.equals("HP")) {
            if (effetHPJ != null) newHPJ = effetHPJ.newValue(joueur, jeu)+1;
            if (effetHPA != null) newHPA = effetHPA.newValue(adversaire, jeu)+1;
        }
        appliquerEffetJoueur(joueur, adversaire, newPPJ, newHPJ, newPPA, newHPA);
        return new ArrayList<>();
    }
}
