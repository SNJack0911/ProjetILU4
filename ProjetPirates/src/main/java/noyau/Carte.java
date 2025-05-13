package noyau;

/**
 * 
 * @author yannf et leo a l'origine
 */

public abstract class Carte {
    private String nom;
    private int carteID;
    private String description;
    private ICategorieCarte categorie;
    private BasicCategorie zoneDepot;

    protected Carte(String nom, int CarteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
        this.zoneDepot = zoneDepot;
        this.carteID = CarteID;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public ICategorieCarte getCategorie() {return categorie;}
    
    public BasicCategorie getZoneDepot(){
        return zoneDepot;
    }
    
    public int getCarteID() {
        return carteID;
    }

    public abstract void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu);
}
