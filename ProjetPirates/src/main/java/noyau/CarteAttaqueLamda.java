package noyau;

import java.util.ArrayList;
import java.util.List;

public class CarteAttaqueLamda extends Carte{
    IEffet effetHPJ;
    IEffet effetHPA;

    public CarteAttaqueLamda(String nom, int carteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot,
                              IEffet effetHPJ, IEffet effetHPA) {
        super(nom, carteID, description, categorie, zoneDepot);
        this.effetHPJ = effetHPJ;
        this.effetHPA = effetHPA;
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu){
        int newHPJ = 0;
        int newHPA = 0;

        if (effetHPJ != null) newHPJ = effetHPJ.newValue(joueur, jeu);
        if (effetHPA != null) newHPA = effetHPA.newValue(adversaire, jeu);
        appliquerEffetJoueur(joueur, adversaire, newHPJ, newHPA);
        return new ArrayList<>();
    }

    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, int newHPJ, int newHPA){
        joueur.applyStats("HP", newHPJ);
        adversaire.applyStats("HP", newHPA);
    }

    protected IEffet getEffetHPJ() {
        return effetHPJ;
    }

    protected IEffet getEffetHPA() {
        return effetHPA;
    }
}
