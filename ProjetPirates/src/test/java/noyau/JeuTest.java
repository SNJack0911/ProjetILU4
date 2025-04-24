package noyau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JeuTest {

    @Test
    void testGetGagnant(){
        Jeu j = new Jeu();
        assertEquals("Pas de gagnant", j.getGagnant(), "Incorrect gagnant value");

        Pirate p1 = j.getPirate(0);
        Pirate p2 = j.getPirate(1);
        p1.applyStats("HP", -5);
        assertEquals(p2.getNom(), j.getGagnant(), "Incorrect gagnant value, HP below 0");

        p1.applyStats("HP", 4);
        p1.applyStats("PP", 5);
        assertEquals(p1.getNom(), j.getGagnant(), "Incorrect gagnant value, PP above 5");

    }
}