package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Pioche {
    private int nbCartes;
    private ArrayList<Carte> cartes;
    private static Random rand = new Random();

    public Pioche(ArrayList<Carte> cartes){
        nbCartes = cartes.size();
        this.cartes = cartes;
    }

    public boolean estVide(){return nbCartes <= 0;};

    public Carte piocher(){
        int randomNum = rand.nextInt(nbCartes);
        Carte carte = cartes.get(randomNum);
        cartes.remove(randomNum);
        nbCartes--;
        return carte;
    }
}
