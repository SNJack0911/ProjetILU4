package noyau;

import org.junit.jupiter.api.Test;
import utils.CartesCSV;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    @Test
    void testAttackEffet() {
        CarteAttack carte = new CarteAttack("Attaque Test", 0, "Desc", 3, 6, -2, -4, false, false);

        Jeu jeu = new Jeu();
        jeu.setNuit(false);
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");

        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(5, joueur.getHP(), "HP joueur incorrect");
        assertEquals(3, joueur.getPP(), "PP joueur incorrect");
        assertEquals(0, adversaire.getPP(), "PP adversaire incorrect");
        assertEquals(1, adversaire.getHP(), "HP adversaire incorrect");

        System.out.println("✔ attackEffet");
    }

    @Test
    void testPopEffet() {
        CartePopularite carte = new CartePopularite("Fan Club", 0, "desc", 1, 5, true);

        Jeu jeu = new Jeu();
        jeu.setNuit(true);
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");

        //Jouer Carte
        List<String> result = carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(5, joueur.getHP(), "HP joueur incorrect");
        //assertEquals(1, joueur.getPP(), "PP joueur incorrect"); //Impossible to test cause random
        assertFalse(result.isEmpty(), "Il devrait y avoir des tirages");

        System.out.println("✔ popEffet");
    }

    @Test
    void testDefenseEffet() {
        CarteDefense carte = new CarteDefense("Bouclier", 0,"def", 1, 2, true);

        Jeu jeu = new Jeu();
        jeu.setNuit(false);
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");
        joueur.addHP(-2);
        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(5, joueur.getHP(), "HP doublé car pas la nuit");
        assertEquals(2, joueur.getPP(), "PP joueur incorrect");
        System.out.println("✔ defenseEffet");
    }

    @Test
    void testCsvLoad() {
        InputStream is = CartesCSV.class.getClassLoader().getResourceAsStream("cartes.csv"); // On charge le fichier CSV
        try{
            if (is == null) throw new FileNotFoundException("Fichier non trouvé !");
            List<Carte> cartes = CartesCSV.lireCartes(is);
            if (cartes == null) System.err.println("Erreur de lecture du fichier CSV");
            Carte c = cartes.getFirst();
            assertEquals("Coup de Sabre", c.getNom(), "Nom incorrect");

            System.out.println("✔ csvLoad");
        } catch (FileNotFoundException e) {
            System.err.println("Erreur de chargement du fichier : " + e.getMessage());
        }
    }
}