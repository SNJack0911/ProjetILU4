package noyau;

import java.util.List;

/**
 *
 * @author yannf
 */

public class CartePiecePopularite extends CartePopulariteLambda{
    private final CoinFlip coinFlip = new CoinFlip();

    public CartePiecePopularite(String nom, int carteID, String description, ICategorieCarte categorie, IEffet effetPPJ, IEffet effetHPJ) {
        super(nom, carteID, description, categorie, effetPPJ, effetHPJ);
    }

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newPPJ, int newHPJ) {
        int compteur = coinFlip.flipCoins();
        joueur.setStats("PP", newPPJ+compteur);
        joueur.setStats("HP", newHPJ);
    }

    public List<String> getCoinFlipResult(){
        return coinFlip.getFace();
    }
}
