package noyau.carteeffet;

import noyau.*;

/**
 *
 * @author yannf et fanny
 */

public class CarteSourdOreille extends CarteEffet {

    public CarteSourdOreille(){
        super("Sourd d'oreille", 19,
                "Les effets diminuant les PV/PP sont inéfectifs pendant ce tour (pour tous les joueurs)", BasicCategorie.POPULARITE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
    	double[] multiplieur = {0,0,0,0};
        jeu.ajouterEffetJeu(new EffetEtatJeu(joueur, adversaire,1, multiplieur,
                TypeChangement.DIMINUTION));
    }
}
