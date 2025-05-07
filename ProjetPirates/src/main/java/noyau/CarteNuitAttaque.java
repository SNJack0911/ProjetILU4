package noyau;

/**
 *
 * @author yannf
 */

public class CarteNuitAttaque extends CarteAttaqueLambda {

    public CarteNuitAttaque (String nom, int carteID, String description,
                             IEffet effetHPJ, IEffet effetHPA) {
        super(nom, carteID, description, effetHPJ, effetHPA);
    }

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newHPJ, int newHPA) {
        //System.out.println(newHPA);
        if(jeu.isNuit()){
            super.appliquerEffetJoueur(joueur, adversaire, jeu, newHPJ, newHPA-1);
        }else{
            super.appliquerEffetJoueur(joueur, adversaire, jeu, newHPJ, newHPA);
        }
    }
}
