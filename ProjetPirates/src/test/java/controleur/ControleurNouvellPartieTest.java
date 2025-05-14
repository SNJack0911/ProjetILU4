package controleur;

import noyau.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControleurNouvellePartieTest {

    private Jeu jeu;
    private ControleurNouvellePartie controleur;

    @BeforeEach
    void setUp() {
        jeu = new Jeu();
        controleur = new ControleurNouvellePartie(jeu);
    }

    @Test
    void testGetTour() {
        jeu.incrementerTour();
        int tour = controleur.getTour();
        assertEquals(1, tour);
    }

    @Test
    void testIncrementerTour() {
        controleur.incrementerTour();
        assertEquals(1, jeu.getTour());
    }

    @Test
    void testIsNuit() {
        jeu.setNuit(true);
        boolean isNuit = controleur.isNuit();
        assertTrue(isNuit);
    }
}