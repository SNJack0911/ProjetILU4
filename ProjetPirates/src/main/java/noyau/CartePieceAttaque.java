package noyau;

import java.util.List;


/**
 *
 * @author yannf
 */

public class CartePieceAttaque extends CarteAttaqueLambda {
    private CoinFlip coinFlip = new CoinFlip();

    public CartePieceAttaque(String nom, int carteID, String description, IEffet effetHPJ, IEffet effetHPA) {
        super(nom, carteID, description, effetHPJ, effetHPA);
    }

    //TODO using super
    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newHPJ, int newHPA) {
        int compteur = coinFlip.flipCoins();
        joueur.setStats("HP", newHPJ);
        adversaire.setStats("HP", newHPA - compteur);
    }

    public List<String> getCoinFlipResult() {
        return coinFlip.getFace();
    }
}