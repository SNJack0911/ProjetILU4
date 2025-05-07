package noyau;

/**
 *
 * @author yannf
 */

public class CarteNuitPopularite extends CartePopulariteLambda{

    public CarteNuitPopularite(String nom, int carteID, String description, ICategorieCarte categorie,
                               IEffet effetPPJ, IEffet effetHPJ) {
        super(nom, carteID, description, categorie, effetPPJ, effetHPJ);
    }

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newPPJ, int newHPJ) {
        if (!jeu.isNuit()){
            super.appliquerEffetJoueur(joueur, adversaire, jeu, newPPJ, newHPJ +1);
        }else {
            super.appliquerEffetJoueur(joueur, adversaire, jeu, newPPJ, newHPJ);
        }
    }
}
