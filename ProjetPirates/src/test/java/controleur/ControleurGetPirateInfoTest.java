package controleur;

import noyau.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControleurGetPirateInfoTest {

    private ControleurGetPirateInfo controleur;
    private Jeu jeu;

    @BeforeEach
    void setUp() {
        jeu = new Jeu();// Intiliser le jeu
        controleur = new ControleurGetPirateInfo(jeu);
    }

    @Test
    void testGetNomPirate_ValidInputs() {
        assertEquals("J1", controleur.getNomPirate(0));
        assertEquals("J2", controleur.getNomPirate(1));
    }

    @Test
    void testGetNomPirate_InvalidInput() {
        assertEquals("Numero de pirates invalide choisir 0 ou 1", controleur.getNomPirate(2));
        assertEquals("Numero de pirates invalide choisir 0 ou 1", controleur.getNomPirate(-1));
    }

    @Test
    void testGetPirateHp_ValidInputs() {
        assertEquals(5, controleur.getPirateHp(0)); // Pirates start with 5 HP
        assertEquals(5, controleur.getPirateHp(1));
    }

    @Test
    void testGetPirateHp_InvalidInput() {
        assertEquals(-1, controleur.getPirateHp(2));
        assertEquals(-1, controleur.getPirateHp(-1));
    }

    @Test
    void testGetPiratePp_ValidInputs() {
        assertEquals(0, controleur.getPiratePp(0)); // Les pirates commencent avec 0 PP
        assertEquals(0, controleur.getPiratePp(1));
    }

    @Test
    void testGetPiratePp_InvalidInput() {
        assertEquals(-1, controleur.getPiratePp(2));
        assertEquals(-1, controleur.getPiratePp(-1));
    }

    @Test
    void testGetPirateMain_ValidInputs() {
        ArrayList<String> mainPirate1 = controleur.getPirateMain(0);
        ArrayList<String> mainPirate2 = controleur.getPirateMain(1);

        assertNotNull(mainPirate1);
        assertNotNull(mainPirate2);
        assertTrue(mainPirate1.size() >= 4 && mainPirate1.size() <= 5); // Apres initialisation, chaque pirate a 4 ou 5 cartes
        assertTrue(mainPirate2.size() >= 4 && mainPirate2.size() <= 5);
    }

    @Test
    void testGetPirateMain_InvalidInput() {
        assertNull(controleur.getPirateMain(2));
        assertNull(controleur.getPirateMain(-1));
    }
}
