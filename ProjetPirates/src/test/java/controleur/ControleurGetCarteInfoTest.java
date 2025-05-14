package controleur;

import noyau.BasicCategorie;
import noyau.ICategorieCarte;
import noyau.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleurGetCarteInfoTest {

    private Jeu jeu;
    private ControleurGetCarteInfo controleur;

    @BeforeEach
    void setUp() {
        jeu = new Jeu();
        controleur = new ControleurGetCarteInfo(jeu);
    }

    @Test
    void testGetDescription() {
        String nomCarte = "Coup bas";
        String expectedDescription = jeu.getJeuDeCarte().getDescription(nomCarte);
        String description = controleur.getDescription(nomCarte);
        assertNotNull(description, "Description should not be null");
        assertEquals(expectedDescription, description, "Description does not match the expected value");
    }

    @Test
    void testGetTypeCarte() {
        String nomCarte = "Coup bas";
        ICategorieCarte expectedType = jeu.getJeuDeCarte().getCategorie(nomCarte);
        ICategorieCarte typeCarte = controleur.getTypeCarte(nomCarte);
        assertNotNull(typeCarte, "Type of the card should not be null");
        assertEquals(expectedType, typeCarte, "Type of the card does not match the expected value");
    }

    @Test
    void testGetZoneDepotCarte() {
        String nomCarte = "Coup bas";
        BasicCategorie expectedZone = jeu.getJeuDeCarte().getZoneDepot(nomCarte);
        BasicCategorie zoneDepot = controleur.getZoneDepotCarte(nomCarte);
        assertNotNull(zoneDepot, "Zone depot should not be null");
        assertEquals(expectedZone, zoneDepot, "Zone depot does not match the expected value");
    }

    @Test
    void testGetCarteID() {
        String nomCarte = "Coup bas";
        int expectedID = jeu.getJeuDeCarte().getCarteID(nomCarte);
        int carteID = controleur.getCarteID(nomCarte);
        assertEquals(expectedID, carteID, "Card ID does not match the expected value");
    }
}