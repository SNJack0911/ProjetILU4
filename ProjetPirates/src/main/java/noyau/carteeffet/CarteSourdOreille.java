package noyau.carteeffet;

import noyau.*;

/**
 *
 * @author yannf
 */

public class CarteSourdOreille extends CarteEffet {

    public CarteSourdOreille(){
        super("Sourd d'oreille", 19,
                "Les effets diminuant les PV/PP sont inéfectifs pendant ce tour (pour tous les joueurs)", BasicCategorie.POPULARITE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        jeu.ajouterEffetJeu(new EffetEtatJeu(1, 0, 0, 0, 0,
                TypeChangement.DIMINUTION));
    }
}
