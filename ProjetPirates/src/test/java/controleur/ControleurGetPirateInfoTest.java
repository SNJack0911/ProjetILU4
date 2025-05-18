package controleur;

import noyau.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Stefan
 * */

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
        assertEquals("Jake Gibbs", controleur.getNomPirate(0));
        assertEquals("Tobias Blackbeard", controleur.getNomPirate(1));
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
        List<String> mainPirate1 = controleur.getPirateMain(0);
        List<String> mainPirate2 = controleur.getPirateMain(1);

        assertNotNull(mainPirate1);
        assertNotNull(mainPirate2);
        assertTrue(mainPirate1.size() >= 4 && mainPirate1.size() <= 5); // Apres initialisation, chaque pirate a 4 ou 5 cartes
        assertTrue(mainPirate2.size() >= 4 && mainPirate2.size() <= 5);
    }

    @Test
    void testGetPirateMain_InvalidInput() {
    	assertEquals(Collections.emptyList(), controleur.getPirateMain(2));
    	assertEquals(Collections.emptyList(), controleur.getPirateMain(-1));
    }
}
