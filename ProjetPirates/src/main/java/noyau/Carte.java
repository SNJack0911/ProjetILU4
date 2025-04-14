package noyau;

import java.util.List;

public abstract class Carte {
    private String nom;
    private String description;
    private CategorieCarte categorie;

    protected Carte(String nom, String description, CategorieCarte categorie) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getCategorie() {return categorie.toString();}

    public abstract void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu);

    //private List<Effet> effets;
    /*
    public Carte(String nom, String description, List<Effet> effets){
        this.nom = nom;
        this.description = description;
        this.effets = effets;
    }
    
    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDescription() {
        return description;
    }
    
    public void appliqueEffets(){
        for (Effet effet : effets) {
            effet.appliqueEffet();
        }
    }*/


}
