package noyau;

import java.util.List;

public class CarteAttack extends Carte{
    private int PPajoutJ;
    private int PVajoutJ;
    private int PPajoutA;
    private int PVajoutA;
    private boolean affectreNuit;


    public CarteAttack(String nom, String description, int PPajoutJ, int PVajoutJ,int PPajoutA, int PVajoutA, boolean affectreNuit) {
        super(nom, description, CategorieCarte.ATTAQUE);
        this.PPajoutJ = PPajoutJ;
        this.PVajoutJ = PVajoutJ;
        this.PPajoutA = PPajoutA;
        this.PVajoutA = PVajoutA;
        this.affectreNuit = affectreNuit;
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        if(affectreNuit&&jeu.isNuit()){
            PVajoutA+=PVajoutA;
            PVajoutJ+=PVajoutJ;
        }
        joueur.applyStats("HP", PVajoutJ);
        joueur.applyStats("PP", PPajoutJ);
        adversaire.applyStats("PP", PPajoutA);
        adversaire.applyStats("HP", PVajoutA);
    }
}
