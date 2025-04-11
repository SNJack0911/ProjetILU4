package noyau;

import java.util.List;

public abstract class Carte implements ICarte {
    private String nom;
    private String description;
    private List<Effet> effets;

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
    
    public abstract void appliqueEffet();
}
