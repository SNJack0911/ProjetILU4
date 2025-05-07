package noyau.carteeffet;

import noyau.*;

/**
 *
 * @author yannf
 */

public class CartePiedMarin extends CarteEffet {

    public CartePiedMarin(){
        super("Le pied marin", 24, "Pendant les deux prochains tours, les effets des cartes sur les PV sont deux fois moins forts",
                BasicCategorie.POPULARITE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        jeu.ajouterEffetJeu(new EffetEtatJeu(2, 0.5, 0.5, 1, 1,
                TypeChangement.TOUS));
    }
}
