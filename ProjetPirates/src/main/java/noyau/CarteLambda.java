package noyau;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannf
 */

public abstract class CarteLambda extends Carte {
    IEffet effet1;
    IEffet effet2;


    public CarteLambda(String nom, int carteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot,
                       IEffet effet1, IEffet effet2) {
        super(nom, carteID, description, categorie, zoneDepot);
        this.effet1 = effet1;
        this.effet2 = effet2;

    }



    protected abstract void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu
            , int newValue1, int newValue2);
   /* protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, int newPPJ, int newHPJ){
        joueur.applyStats("PP", newPPJ);
        joueur.applyStats("HP", newHPJ);
    }

    protected IEffet getEffet1() {
        return effet1;
    }

    protected IEffet getEffet2() {
        return effet2;
    }*/
}
