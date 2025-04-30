package noyau;


//NEVER USED
public class CarteStructurel {
    private String nom;
    private String description;
    private ICategorieCarte categorie;

    public CarteStructurel(String nom, String description, ICategorieCarte categorie) {
        this.nom = nom;
        this.description = description;
        this.categorie = categorie;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public ICategorieCarte getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "Carte [nom=" + nom + ", description=" + description + ", catégorie=" + categorie + "]";
    }
}

