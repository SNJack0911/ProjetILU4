package controleur;

import noyau.Carte;
import noyau.CarteDefense;
import noyau.CartePopularite;
import noyau.Jeu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControleurPiocherCarteTest {

    @Test
    void testListeCarteToString() {
        // Setup
        ArrayList<Carte> cartes = new ArrayList<>();
        cartes.add(new CartePopularite("Carte1", 1, "desc", 1, 1, false));
        cartes.add(new CarteDefense("Carte2", 2, "desc", 10, 5, false));

        // Action
        ArrayList<String> noms = ControleurPiocherCarte.listeCarteToString(cartes);

        // Assertion
        assertEquals(2, noms.size());
        assertEquals("Carte1", noms.get(0));
        assertEquals("Carte2", noms.get(1));
    }

    @Test
    void testPiocherCarte() {
        // Construir un jeu fictif
        Jeu jeu = new Jeu();
        ControleurPiocherCarte controleur = new ControleurPiocherCarte(jeu);
        ArrayList<String> noms = controleur.piocherCarte();
        assertNotNull(noms);
        assertFalse(noms.isEmpty(), "La liste de cartes piochées ne devrait pas être vide.");
        // Vérifier que les noms des cartes piochées sont valides
        for (String nom : noms) {
            assertNotNull(nom, "Le nom de la carte ne devrait pas être null.");
            assertFalse(nom.isEmpty(), "Le nom de la carte ne devrait pas être vide.");
        }
    }
}
