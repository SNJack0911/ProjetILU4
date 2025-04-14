package noyau;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CarteDefense extends  Carte{
    private int PVajout;
    private int PPajout;
    private boolean affecterNuit;

    public CarteDefense(String nom, String description, int PVajout, int PPajout, boolean affecterNuit) {
        super(nom, description, CategorieCarte.DEFENSE);
        this.PVajout = PVajout;
        this.PPajout = PPajout;
        this.affecterNuit = affecterNuit;
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        if(affecterNuit && !jeu.isNuit()){
            PVajout += PVajout;
        }
        joueur.applyStats("HP", PVajout);
        joueur.applyStats("PP", PPajout);
        //Voir pour ajouter effet

        //Effet e = new Effet(joueur,  new Map<String, Integer>());
    }
}
/*
CarteDefense c1 = new CarteDefense("Hymne", "desc", 1, 0);
Carte ca = new UniqueCarte(){

};*/