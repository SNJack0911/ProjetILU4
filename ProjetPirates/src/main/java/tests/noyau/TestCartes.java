package tests.noyau;

import noyau.*;
import utils.CartesCSV;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class TestCartes {

    public static void main(String[] args) {
        testAttackEffet();
        testPopEffet();
        testDefenseEffet();
        testCsvLoad();
        System.out.println("Tous les tests terminés.");
    }

    // Test CarteAttack
    static void testAttackEffet() {
        CarteAttack carte = new CarteAttack("Attaque Test", 0, "Desc", 3, 6, -2, -4, false, false);

        Jeu jeu = new Jeu();
        jeu.setNuit();
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");

        carte.appliquerEffet(joueur, adversaire, jeu);

        assert joueur.getHP() == 6 : "HP joueur incorrect";
        assert joueur.getPP() == 3 : "PP joueur incorrect";
        assert adversaire.getPP() == -2 : "PP adversaire incorrect";
        assert adversaire.getHP() == -4 : "HP adversaire incorrect";

        System.out.println("✔ attackEffet");
    }

    // Test CartePopularite
    static void testPopEffet() {
        CartePopularite carte = new CartePopularite("Fan Club", 0, "desc", 1, 5, true);

        Jeu jeu = new Jeu();
        jeu.setNuit();
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");

        List<String> result = carte.appliquerEffet(joueur, adversaire, jeu);

        assert joueur.getHP() >= 5 : "HP joueur incorrect";
        assert joueur.getPP() >= 0 : "PP joueur devrait être >= 0";
        assert !result.isEmpty() : "Il devrait y avoir des tirages";

        System.out.println("✔ popEffet");
    }

    // Test for CarteDefense
    static void testDefenseEffet() {
        CarteDefense carte = new CarteDefense("Bouclier", 0, "def", 5, 2, true);

        Jeu jeu = new Jeu();
        jeu.setNuit();
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");

        carte.appliquerEffet(joueur, adversaire, jeu);

        assert joueur.getHP() == 10 : "HP doublé car pas la nuit";
        assert joueur.getPP() == 2 : "PP joueur incorrect";

        System.out.println("✔ defenseEffet");
    }

    // Test CSV
    static void testCsvLoad() {
        InputStream is = CartesCSV.class.getClassLoader().getResourceAsStream("cartes.csv"); // On charge le fichier CSV
        try{
            if (is == null) throw new FileNotFoundException("Fichier non trouvé !");
                List<Carte> cartes = CartesCSV.lireCartes(is);
            Carte c = cartes.get(0);
            assert c.getNom().equals("Coup de Sabre") : "Nom incorrect";

            System.out.println("✔ csvLoad");
        } catch (FileNotFoundException e) {
            System.err.println("Erreur de chargement du fichier : " + e.getMessage());
            return;
        }
    }
}
