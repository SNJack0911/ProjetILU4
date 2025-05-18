package noyau;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import reference.*;
/*
 * Stefan
 * */

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

    @Test
    void testInitJeu() {
        Jeu jeu = new Jeu();
        Pirate p1 = jeu.getPirate(0);
        Pirate p2 = jeu.getPirate(1);

        assertEquals(4, p1.getNbCarte(), "Joueur 1 doit avoir 4 cartes après init");
        assertEquals(4, p2.getNbCarte(), "Joueur 2 doit avoir 4 cartes après init");
        assertEquals(0, jeu.getTour(), "Tour faudrait être 0 après init");
        assertNotNull(jeu.getJeuDeCarte(), "JeuDeCarte ne doit pas être null");
    }

    @Test
    void testJouerPioche() {
        Jeu jeu = new Jeu();
        Pirate current = jeu.getPirate(0); // tour = 0 → joueur1

        current.getMain().clear(); // Empty hand pour test
        assertEquals(0, current.getNbCarte());

        List<Carte> cartes = jeu.jouerPioche();
        assertEquals(5, current.getNbCarte(), "Main faudra avoir 5 cartes après piocher");
        assertEquals(5, cartes.size(), "Il faut 5 cartes dans la main du joueur");
    }

    @Test
    void testTourIncrements() {
        Jeu jeu = new Jeu();
        Pirate joueur = jeu.getPirate(0);
        Pirate adversaire = jeu.getPirate(1);
        jeu.incrementerTour();
        assertEquals(1, jeu.getTour(), "Tour devrait être incrémenté après jouer une carte");

        assertEquals(joueur, jeu.getAdversaireActuel(), "Le bon adversaire n'est pas choisi");
        assertEquals(adversaire, jeu.getJoueurActuel(), "Le bon joueur n'est pas choisi");
    }

    @Test
    void testJouerTour_Deterministic() {
        Jeu jeu = new Jeu();
        Pirate joueur = jeu.getPirate(0);
        joueur.getMain().clear();

        Carte testCarte = new CartePopularite("UNIQUE_TEST_CARD", -1, "Test", 1, 0, false);
        joueur.addCarte(testCarte);

        List<String> resultValid = jeu.jouerTour("UNIQUE_TEST_CARD");
        assertFalse(resultValid.get(0).contains("Carte not found"), "Carte devrait être trouvée et jouée");
        assertEquals(0, joueur.getNbCarte(), "Carte devrait être supprimée après avoir été jouée");

        List<String> resultInvalid = jeu.jouerTour("Inexistante");
        assertTrue(resultInvalid.get(0).contains("Carte pas trouvée"), "Carte invalide ne devrait pas être jouée");
    }


    @Test
    void testPlayNullCardName() {
        Jeu jeu = new Jeu();

        List<String> result = jeu.jouerTour(null);
        assertEquals(1, result.size());
        assertTrue(result.get(0).contains("Carte pas trouvée"), "Null carte ne faudrait pas être jouée");
    }

    @Test
    void testDuplicateCardNames() {
        Jeu jeu = new Jeu();
        Pirate joueur = jeu.getPirate(0);
        joueur.getMain().clear();

        Carte c1 = new CartePopularite("Dup", -1, "Test", 1, 0, false);
        Carte c2 = new CartePopularite("Dup", -1, "Test2", 1, 0, false);
        joueur.addCarte(c1);
        joueur.addCarte(c2);

        jeu.jouerTour("Dup");

        assertEquals(1, joueur.getNbCarte(), "Que une carte devrait être jouée");
    }

    @Test
    void testGameEndsAfterHPZero() {
        Jeu jeu = new Jeu();
        Pirate joueur1 = jeu.getPirate(0);
        joueur1.addHP(-5);
        assertTrue(jeu.isJeuTermine(), "Le jeu devrait être terminé si un joueur a 0 HP");
    }

    @Test
    void testGameEndsAfterPPFive() {
        Jeu jeu = new Jeu();
        Pirate joueur1 = jeu.getPirate(0);
        joueur1.addPP(6);
        assertTrue(jeu.isJeuTermine(), "Le jeu devrait être terminé si un joueur a 5 PP");
    }

    @Test
    void testNuitToggle() {
        Jeu jeu = new Jeu();
        assertFalse(jeu.isNuit(), "Il faudrait être jour par défaut");

        jeu.setNuit(true);
        assertTrue(jeu.isNuit(), "Il faudrait être nuit après le changement");
    }

    @Test
    void testJouerPiocheWhenHandFull() {
        Jeu jeu = new Jeu();
        Pirate joueur = jeu.getPirate(0);
        while (joueur.getNbCarte() < 5) {
            joueur.addCarte(new CartePopularite("Test", 1, "Desc", 0, 0, false));
        }
        List<Carte> newCards = jeu.jouerPioche();
        assertEquals(0, newCards.size(), "Aucune carte ne devrait être piochée si la main est déjà pleine");
    }




}