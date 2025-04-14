package noyau;

public class CarteStructurel {
    private String nom;
    private String description;
    private CategorieCartes categorie;

    public CarteStructurel(String nom, String description, CategorieCartes categorie) {
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

    public CategorieCartes getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return "Carte [nom=" + nom + ", description=" + description + ", catégorie=" + categorie + "]";
    }
}

/*  La liste des cartes qu'on devra creer :
Carte carte1 = new Carte("Touché d'encre",
                         "Choisissez une carte à faire défausser à l'adversaire. (L'adversaire doit ensuite piocher une nouvelle carte)",
                         CategorieCarte.EFFET);

Carte carte2 = new Carte("Sourd d'oreille",
                         "Les effets diminuant les PV/PP sont inéfectifs pendant ce tour (pour tous les joueurs)",
                         CategorieCarte.EFFET);

Carte carte3 = new Carte("Effet Amplificateur",
                         "Les effets augmentant les PV/PP sont doublés pendant les 3 prochains tours (on peut le faire pendant une période nuit)",
                         CategorieCarte.EFFET);

Carte carte4 = new Carte("Dénie",
                         "Annule la carte adverse précédente (sur le terrain). (Si le joueur adverse a posé un +3PV => retire les 3 PV)",
                         CategorieCarte.EFFET);

Carte carte5 = new Carte("Douceur ensoleillée",
                         "Gagne 1 PV, gagne 1 PV de plus si c'est le jour",
                         CategorieCarte.EFFET);

Carte carte6 = new Carte("Jacko le fouineur",
                         "Regarde les 2 prochaines cartes de la pioche du joueur de son choix",
                         CategorieCarte.EFFET);

Carte carte7 = new Carte("Antidouleur en herbe",
                         "Prévient de la prochaine source de dégâts auto-infligés. Gagne 1 PV",
                         CategorieCarte.EFFET);

Carte carte8 = new Carte("Carte piège Yugi",
                         "Masque la prochaine carte jouée à l'adversaire. Vous pouvez jouer une nouvelle carte pour ce tour. Elle sera jouée dans 3 tours",
                         CategorieCarte.EFFET);

Carte carte9 = new Carte("Héros de shonen / Outsider prolifique",
                         "Le joueur perd un point de popularité mais peut jouer deux autres cartes ce tour",
                         CategorieCarte.POPULARITE);

Carte carte10 = new Carte("La chance sourit aux audacieux",
                          "Le joueur lance une pièce, tant que face, il gagne +1 PP",
                          CategorieCarte.POPULARITE);

Carte carte11 = new Carte("Le malade imaginaire",
                          "Le joueur gagne 2 PP mais perd 1 PV",
                          CategorieCarte.POPULARITE);

Carte carte12 = new Carte("Peau de Banane",
                          "L'adversaire perd 1 PP",
                          CategorieCarte.ATTAQUE);

Carte carte13 = new Carte("Le tout pour le tout",
                          "L'adversaire perd 3 PV, si il survit, il gagne 3 PP",
                          CategorieCarte.ATTAQUE);

Carte carte14 = new Carte("Coup bas",
                          "L'adversaire perd 1 PV",
                          CategorieCarte.ATTAQUE);

Carte carte15 = new Carte("Kamikaze",
                          "Inflige 2 PV à l'adversaire. Inflige 1 PV à soi-même",
                          CategorieCarte.ATTAQUE);

Carte carte16 = new Carte("Dans ta Face",
                          "Le joueur lance une pièce, tant que face, l'adversaire perd 1 PV",
                          CategorieCarte.ATTAQUE);

Carte carte17 = new Carte("Fureur de la nuit",
                          "Inflige 1 PV à l'adversaire, inflige 1 PV de plus si c'est la nuit",
                          CategorieCarte.ATTAQUE);

Carte carte18 = new Carte("Hymne à Flute",
                          "Le joueur gagne 1 PV",
                          CategorieCarte.DEFENSE);

Carte carte19 = new Carte("Ode à la Joie",
                          "Le joueur gagne 3 PV",
                          CategorieCarte.DEFENSE);

Carte carte20 = new Carte("Anticipation",
                          "Bloque la prochaine attaque de la carte adverse",
                          CategorieCarte.DEFENSE);

*/
