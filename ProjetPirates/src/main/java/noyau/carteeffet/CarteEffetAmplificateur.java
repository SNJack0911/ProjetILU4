package noyau.carteeffet;

import noyau.*;

/**
 *
 * @author yannf
 */

public class CarteEffetAmplificateur extends CarteEffet {

    public CarteEffetAmplificateur(){
        super("Effet Amplificateur", 17, "Les effets augmentant les PV/PP sont doublé pendant les 3 prochains tour (on peut le faire pendant une periode nuit)",
                BasicCategorie.POPULARITE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        jeu.ajouterEffetJeu(new EffetEtatJeu(joueur, adversaire, 3, 2, 2, 2, 2,
                TypeChangement.AUGMENTATION));
    }
}
