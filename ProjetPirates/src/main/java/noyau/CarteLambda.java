package noyau;

import java.util.List;

/**
 *
 * @author yannf et fanny
 */

public abstract class CarteLambda extends Carte {
    IEffet effet1;
    IEffet effet2;
    final CoinFlip coinFlip ;

    protected CarteLambda(String nom, int carteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot,
                       IEffet effet1, IEffet effet2) {
        super(nom, carteID, description, categorie, zoneDepot);
        this.effet1 = effet1;
        this.effet2 = effet2;
        this.coinFlip = new CoinFlip();
    }

    public List<String> getCoinFlipResult(){
        return coinFlip.getFace();
    }
    
    protected abstract void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu
            , int newValue1, int newValue2);
}
