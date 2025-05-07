package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author yannf
 */

public class CartePopularite extends Carte {
    private int PPajoutJ;   //final ?
    private int PVajoutJ;   //final ?
    private boolean lancerPiece; //final ?
    private static final Random rand = new Random();


    public CartePopularite(String nom, int carteID, String description, int PPajoutJ, int PVajoutJ, boolean lancerPiece) {
        super(nom, carteID, description, BasicCategorie.POPULARITE, BasicCategorie.POPULARITE);
        this.PPajoutJ = PPajoutJ;
        this.PVajoutJ = PVajoutJ;
        this.lancerPiece = lancerPiece;
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        List<String> listeFace = new ArrayList<>();
        int compteur = 1;
        if(lancerPiece){
            int face;
            compteur = -1;
            do{
                face = rand.nextInt(2);
                compteur+=1;
                listeFace.add(face + "");
            }while (face != 1);
        }
        joueur.applyStats("HP", PVajoutJ);
        joueur.applyStats("PP", PPajoutJ*compteur);
        //return listeFace;
    }
}
