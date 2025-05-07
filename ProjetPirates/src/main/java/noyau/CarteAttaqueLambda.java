package noyau;

/**
 *
 * @author yannf
 */

public class CarteAttaqueLambda extends CarteLambda{

    public CarteAttaqueLambda(String nom, int carteID, String description,
                              IEffet effetHPJ, IEffet effetHPA) {
        super(nom, carteID, description, BasicCategorie.ATTAQUE, BasicCategorie.ATTAQUE, effetHPJ, effetHPA);
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        int newHPJ = joueur.getHP();
        int newHPA = adversaire.getHP();

        if (effet1 != null) newHPJ = effet1.newValue(joueur, jeu);
        if (effet2 != null) newHPA = effet2.newValue(adversaire, jeu);

        appliquerEffetJoueur(joueur, adversaire, jeu, newHPJ, newHPA);
    }

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newHPJ, int newHPA) {
        joueur.setStats("HP", newHPJ);
        adversaire.setStats("HP", newHPA);
    }
}
