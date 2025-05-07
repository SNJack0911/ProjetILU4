package noyau.carteeffet;

import noyau.*;

/**
 *
 * @author yannf
 */

public class CarteAntidouleur extends CarteEffet {

    public CarteAntidouleur(){
        super("Antidouleur", 15, "Prévient de la prochaine source de dégâts auto-infligé. Gagne 1 PV",
                BasicCategorie.POPULARITE);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        joueur.applyStats("HP", 1);
        jeu.ajouterEffetJeu(new EffetEtatJeu(1, 1,1, 1,1,TypeChangement.TOUS){
            @Override
            public void finTour(Pirate pirate1, Pirate pirate2) {
                if(pirate1.equals(joueur) && pirate1.getHP() < getGameState(1)){
                    pirate1.setStats("HP", getGameState(1));
                    updateTourRestant();
                } else if(pirate2.equals(joueur) && pirate2.getHP() < getGameState(1)){
                    pirate2.setStats("HP", getGameState(1));
                    updateTourRestant();
                }
            }
        });
    }
}
