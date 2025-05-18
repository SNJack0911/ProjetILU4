package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author yannf
 */

public class Pioche {
    private int nbCartes;
    private final List<Carte> cartes;
    private static final Random rand = new Random();

    public Pioche(List<Carte> list){
        nbCartes = list.size();
        this.cartes = list;
    }

    public boolean estVide(){return nbCartes <= 0;}

    public Carte piocher() throws IllegalStateException{
        if (estVide()) {
            throw new IllegalStateException("Impossible de piocher dans une pioche vide !");
        }
        int randomNum = rand.nextInt(nbCartes);
        Carte carte = cartes.get(randomNum);
        cartes.remove(randomNum);
        nbCartes--;
        return carte;
    }
    public int getNbCartes() {
        return nbCartes;
    }

    public int getCartesSize() {
        return cartes.size();
    }
}
