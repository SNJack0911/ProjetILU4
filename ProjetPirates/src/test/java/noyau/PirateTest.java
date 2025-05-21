package noyau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import reference.*;
/*
 * Stefan
 * Yann
 * */

class PirateTest {

    @Test
    void testInit(){
        Pirate p = new Pirate("Pierre");
        assertEquals(5, p.getHP());
        assertEquals(0, p.getPP());
        assertEquals("Pierre", p.getNom());
        System.out.println("Init test passed");
    }

    @Test
    void testHp(){
        Pirate p = new Pirate("HpTester");
        p.applyStats("HP", -3);//2
        assertEquals(2, p.getHP(), "Incorrect HP value, minus 3");

        p.applyStats("HP", 10); //5
        assertEquals(5, p.getHP(), "Incorrect HP value, plus more than 5");

        p.applyStats("HP", -10); //0
        assertEquals(0, p.getHP(), "Incorrect HP value, minus more than 5");

        System.out.println("testHP passed");
    }

    @Test
    void testPP(){
        Pirate p = new Pirate("PPTester");
        p.applyStats("PP", 4);
        assertEquals(4, p.getPP(), "Incorrect PP value, plus 4");

        p.applyStats("PP", 10);
        assertEquals(5, p.getPP(), "Incorrect PP value, plus more than 5");

        p.applyStats("PP", -10);
        assertEquals(0, p.getPP(), "Incorrect PP value, minus more than 5");
    }

    @Test
    void testAddCarteMain(){
        Pirate p = new Pirate("CardTester1");
        Carte card = new CarteAttack("C1", 0,"Carte Attaque", 1, 0, 0, -1, false, false);
        p.addCarte(card);

        assertEquals(1, p.getMain().size(), "Card not added properly to the Pirate's hand");
        System.out.println("testAddCarte passed");
    }

    @Test
    void testGetCarteMain(){
        Pirate p = new Pirate("CardTester2");
        Carte card = new CartePopularite("Popular", 0, "Boost", 2, 1, false);
        p.addCarte(card);
        Carte found = p.getCarteMain("Popular");
        assertNotNull(found,"No return carte main");
        assertEquals(card, found, "Got an unexpected carte from getCarteMain()");
        System.out.println("testGetCarteMain passed");
    }

    @Test
    void testGetNbCarte(){
        Pirate p = new Pirate("CardTester3");
        p.addCarte(new CarteAttack("A", 0, "Attack", 1, 1, 0, -1, false, false));
        p.addCarte(new CarteDefense("D", 0, "Defense", 2, 0, false));
        assertEquals(2, p.getNbCarte(), "Incorrect NbCarte value");
        System.out.println("testGetNbCarte passed");
    }

    @Test
    void testSupprimerCarteMain(){
        Pirate p = new Pirate("CardTester4");
        Carte card = new CarteDefense("Defense", 0, "Blockage", 2, 0, false);
        p.addCarte(card);
        assertEquals(1, p.getNbCarte(), "Card not added properly to the Pirate's hand");
        p.supprimerCarteMain(card);
        assertEquals(0, p.getNbCarte(), "Card not deleted properly from the Pirate's hand");

        assertThrows(IllegalArgumentException.class, () -> {
            p.supprimerCarteMain(card);
        }, "Expected IllegalArgumentException when removing a card not in hand");
        
        System.out.println("testSupprimerCarteMain passed");
    }

    @Test
    void testApplyStats_InvalidStat() {
        Pirate p = new Pirate("InvalidStatTester");
        boolean result = p.applyStats("XYZ", 3);
        assertFalse(result, "applyStats should return false for unrecognized stat");
    }

    @Test
    void testSetStats_InvalidStat() {
        Pirate p = new Pirate("StatSetter");
        assertThrows(IllegalArgumentException.class, () -> p.setStats("XYZ", 3));
    }

    @Test
    void testEquals() {
        Pirate p1 = new Pirate("Jack");
        Pirate p2 = new Pirate("Jack");
        Pirate p3 = new Pirate("Anne");
        Integer i1 = 0;

        assertEquals(p1, p2);
        assertNotEquals(p1, p3);
        assertNotEquals(p1, i1);
    }

    @Test
    void testSetStatsLimits() {
        Pirate p = new Pirate("StatLimiter");

        p.setStats("HP", 10);
        assertEquals(5, p.getHP(), "HP should not exceed 5");

        p.setStats("HP", -3);
        assertEquals(0, p.getHP(), "HP should not go below 0");

        p.setStats("PP", 7);
        assertEquals(5, p.getPP(), "PP should not exceed 5");

        p.setStats("PP", -1);
        assertEquals(0, p.getPP(), "PP should not go below 0");
    }

    @Test
    void testToStringContainsNameAndStats() {
        Pirate p = new Pirate("Jean");
        String repr = p.toString();

        assertTrue(repr.contains("Jean"), "toString should contain the pirate's name");
        assertTrue(repr.contains("HP=5"), "toString should show initial HP");
        assertTrue(repr.contains("PP=0"), "toString should show initial PP");
    }

    @Test
    void testGetCarteMainNotFound() {
        Pirate p = new Pirate("NoCardFinder");
        Carte result = p.getCarteMain("GhostCard");

        assertNull(result, "Should return null when the card is not found in hand");
    }

    @Test
    void testPirateHashCode() {
        Pirate p1 = new Pirate("Jack");
        Pirate p2 = new Pirate("Jack");
        Pirate p3 = new Pirate("Anne");
        Pirate p4 = new Pirate(null);

        assertEquals(p1.hashCode(), p2.hashCode(), "Deux pirates avec le même nom doivent avoir le même hashCode");
        assertNotEquals(p1.hashCode(), p3.hashCode(), "Deux pirates avec des noms différents devraient avoir des hashCodes différents");
        assertEquals(p4.hashCode(), 0, "Un pirate sans nom a un hashCode invalide de 0");
        
    }



}