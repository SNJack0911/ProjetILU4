package noyau;

import java.util.Random;

public class CartePopularite extends Carte {
    private int PPajoutJ;
    private int PVajoutJ;
    private boolean lancerPiece;
    private static Random rand = new Random();


    public CartePopularite(String nom, String description, int PPajoutJ, int PVajout, boolean lancerPiece) {
        super(nom, description, CategorieCarte.ATTAQUE);
        this.PPajoutJ = PPajoutJ;
        this.PVajoutJ = PVajoutJ;
        this.lancerPiece = lancerPiece;
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        if(lancerPiece){
            int face;
            do{
                face = rand.nextInt(1);
                //TODO Retrun
            }while (face != 1);
        }
        joueur.applyStats("HP", PVajoutJ);
        joueur.applyStats("PP", PPajoutJ);
    }
}
