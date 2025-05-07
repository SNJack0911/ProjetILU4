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
        super("Touché d'encre", 20, "Une des cartes de l'adversaire est défaussée ", BasicCategorie.ATTAQUE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        List<Carte> possible = adversaire.getMain();
        Random rand = new Random();
        int randomIndex = rand.nextInt(possible.size());
        adversaire.supprimerCarteMain(possible.get(randomIndex));
    }
}
