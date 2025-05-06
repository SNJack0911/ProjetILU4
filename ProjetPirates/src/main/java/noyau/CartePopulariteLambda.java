package noyau;

import java.util.ArrayList;
import java.util.List;

public class CartePopulariteLambda extends CarteLambda {

    public CartePopulariteLambda(String nom, int carteID, String description, ICategorieCarte categorie,
                                 IEffet effetPPJ, IEffet effetHPJ) {
        super(nom, carteID, description, categorie, BasicCategorie.POPULARITE, effetPPJ, effetHPJ);
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        int newPPJ = joueur.getPP();
        int newHPJ = joueur.getHP();

        if (effet1 != null) newPPJ = effet1.newValue(joueur, jeu);
        if (effet2 != null) newHPJ = effet2.newValue(joueur, jeu);

        appliquerEffetJoueur(joueur, adversaire, jeu, newPPJ, newHPJ);
        return new ArrayList<>();
    }

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newPPJ, int newHPJ) {
        joueur.setStats("PP", newPPJ);
        joueur.setStats("HP", newHPJ);
    }
}
