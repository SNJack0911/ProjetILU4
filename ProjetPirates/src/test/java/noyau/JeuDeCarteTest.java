package noyau;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JeuDeCarteTest {

    @Test
    void testRemplirPioche() {//TO CHANGE WHEN ADDING THE REAL CARDS
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        ArrayList<Carte> pioche = jeuDeCarte.remplirPioche();
        assertFalse(pioche.isEmpty(), "Le deck ne doit pas être vide après remplissage.");

        int expectedTotalCards = 10 * 6; // 6 configurations, with 20 cards each
        assertEquals(expectedTotalCards, pioche.size(), "Le nombre total de cartes dans le deck est incorrect.");
    }

    @Test
    void testGetDescription_ValidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        String description = jeuDeCarte.getDescription("Plus1Pop");
        assertEquals("Le joueur Gagne 1PP", description, "La description de la carte doit correspondre à celle attendue.");
    }

    @Test
    void testGetDescription_InvalidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        String description = jeuDeCarte.getDescription("InvalidCard");
        assertEquals("Card not found", description, "La description de la carte doit être 'Card not found' pour une carte invalide.");
    }

    @Test
    void testGetCarteID_ValidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        int carteID = jeuDeCarte.getCarteID("Plus1Pop");
        assertEquals(-1, carteID, "L'ID de la carte doit être -1 pour une carte valide.");
    }

    @Test
    void testGetCarteID_InvalidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        int carteID = jeuDeCarte.getCarteID("InvalidCard");
        assertEquals(-1, carteID, "L'ID de la carte doit être -1 pour une carte invalide.");
    }

    @Test
    void testGetCategorie_ValidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        ICategorieCarte categorie = jeuDeCarte.getCategorie("Plus1Pop");
        assertNotNull(categorie, "La catégorie ne doit pas être nulle pour une carte valide.");
    }

    @Test
    void testGetCategorie_InvalidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        ICategorieCarte categorie = jeuDeCarte.getCategorie("InvalidCard");
        assertNull(categorie, "La catégorie doit être nulle pour une carte invalide.");
    }

    @Test
    void testGetZoneDepot_ValidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        BasicCategorie zoneDepot = jeuDeCarte.getZoneDepot("Plus1Pop");
        assertNotNull(zoneDepot, "La zone depot ne doit pas être nulle pour une carte valide.");
    }

    @Test
    void testGetZoneDepot_InvalidCard() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        BasicCategorie zoneDepot = jeuDeCarte.getZoneDepot("InvalidCard");
        assertNull(zoneDepot, "La zone depot doit être nulle pour une carte invalide.");
    }
}