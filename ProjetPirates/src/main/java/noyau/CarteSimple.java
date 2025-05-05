package noyau;

import java.util.ArrayList;
import java.util.List;

public class CarteSimple extends Carte {
    IEffet effetPPJ;
    IEffet effetHPJ;


    public CarteSimple(String nom, int carteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot,
                       IEffet effetPPJ, IEffet effetHPJ) {
        super(nom, carteID, description, categorie, zoneDepot);
        this.effetPPJ = effetPPJ;
        this.effetHPJ = effetHPJ;

    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        int newPPJ = 0;
        int newHPJ = 0;

        if (effetPPJ != null) newPPJ = effetPPJ.newValue(joueur, jeu);
        if (effetHPJ != null) newHPJ = effetHPJ.newValue(joueur, jeu);

        appliquerEffetJoueur(joueur, adversaire, newPPJ, newHPJ);
        return new ArrayList<>();
    }

    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, int newPPJ, int newHPJ){
        joueur.applyStats("PP", newPPJ);
        joueur.applyStats("HP", newHPJ);
    }

    protected IEffet getEffetPPJ() {
        return effetPPJ;
    }

    protected IEffet getEffetHPJ() {
        return effetHPJ;
    }
}
