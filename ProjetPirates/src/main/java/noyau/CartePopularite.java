package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CartePopularite extends Carte {
    private int PPajoutJ;
    private int PVajoutJ;
    private boolean lancerPiece;
    private static final Random rand = new Random();


    public CartePopularite(String nom, String description, int PPajoutJ, int PVajout, boolean lancerPiece) {
        super(nom, description, BasicCategorie.POPULARITE, BasicCategorie.POPULARITE);
        this.PPajoutJ = PPajoutJ;
        this.PVajoutJ = PVajoutJ;
        this.lancerPiece = lancerPiece;
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        List<String> listeFace = new ArrayList<String>();
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
        return listeFace;
    }
}
