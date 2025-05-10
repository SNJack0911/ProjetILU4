package noyau.carteeffet;

import noyau.*;

import java.util.List;
import java.util.Random;

/**
 *
 * @author hai, yannf
 */

public class CarteToucheEncre extends CarteEffet {


    public CarteToucheEncre() {
        super("Toucher d'encre", 20, "Une des cartes de l'adversaire est défaussée ", BasicCategorie.ATTAQUE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        List<Carte> possible = adversaire.getMain();
        int nbCarte = possible.size();
        if (nbCarte <= 0) {return;}

        Random rand = new Random();
        int randomIndex = rand.nextInt(nbCarte);
        adversaire.supprimerCarteMain(possible.get(randomIndex));
    }
}
