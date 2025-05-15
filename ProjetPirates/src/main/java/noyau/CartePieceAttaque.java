package noyau;



/**
 *
 * @author yannf
 */

public class CartePieceAttaque extends CarteAttaqueLambda {

    public CartePieceAttaque(String nom, int carteID, String description, IEffet effetHPJ, IEffet effetHPA) {
        super(nom, carteID, description, effetHPJ, effetHPA);
    }

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newHPJ, int newHPA) {
        int compteur = coinFlip.flipCoins();
        joueur.setStats("HP", newHPJ);
        adversaire.setStats("HP", newHPA - compteur);
    }

}