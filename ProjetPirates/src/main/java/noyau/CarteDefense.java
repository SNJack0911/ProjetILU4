package noyau;

import java.util.*;

public class CarteDefense extends  Carte{
    private int PVajout;
    private int PPajout;
    private boolean affecterNuit;

    public CarteDefense(String nom, String description, int PVajout, int PPajout, boolean affecterNuit) {
        super(nom, description, ExtendCategorie.DEFENSE, BasicCategorie.POPULARITE);
        this.PVajout = PVajout;
        this.PPajout = PPajout;
        this.affecterNuit = affecterNuit;
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        //List<String> listeFace = new ArrayList<String>();
        if(affecterNuit && !jeu.isNuit()){
            PVajout += PVajout;
        }
        joueur.applyStats("HP", PVajout);
        joueur.applyStats("PP", PPajout);
        //Voir pour ajouter effet

        //Effet e = new Effet(joueur,  new Map<String, Integer>());
        return new ArrayList<String>();
    }
}