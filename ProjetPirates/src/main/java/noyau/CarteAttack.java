package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarteAttack extends Carte{
    private int PPajoutJ;
    private int PVajoutJ;
    private int PPajoutA;
    private int PVajoutA;
    private boolean affectreNuit;
    private boolean lancerPiece;
    private static Random rand = new Random();


    public CarteAttack(String nom, String description, int PPajoutJ, int PVajoutJ,int PPajoutA, int PVajoutA, boolean affectreNuit, boolean piece) {
        super(nom, description, CategorieCarte.ATTAQUE);
        this.PPajoutJ = PPajoutJ;
        this.PVajoutJ = PVajoutJ;
        this.PPajoutA = PPajoutA;
        this.PVajoutA = PVajoutA;
        this.affectreNuit = affectreNuit;
        this.lancerPiece = piece;
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        List<String> listeFace = new ArrayList<String>();
        if(affectreNuit&&jeu.isNuit()){
            PVajoutA+=PVajoutA;
            PVajoutJ+=PVajoutJ;
        }
        int compteur = 1;
        if(lancerPiece){
            int face;
            compteur = -1;
            do{
                face = rand.nextInt(2);
                compteur+=1;
                listeFace.add(face + "");
            }while (face != 1 && compteur <= 3); //Je pense que ca sert a rien de limiter
        }

        joueur.applyStats("HP", PVajoutJ);
        joueur.applyStats("PP", PPajoutJ);
        adversaire.applyStats("PP", PPajoutA);
        adversaire.applyStats("HP", PVajoutA*compteur);
        return listeFace;
    }
}
