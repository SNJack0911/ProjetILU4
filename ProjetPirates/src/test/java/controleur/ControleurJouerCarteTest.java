package controleur;

import noyau.Carte;
import reference.CartePopularite;
import noyau.Jeu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControleurJouerCarteTest {

    private Jeu jeu;
    private ControleurJouerCarte controleur;

    @BeforeEach
    void setUp() {
        jeu = new Jeu();
        controleur = new ControleurJouerCarte(jeu);
    }

    @Test
    void testJouerCarte_ValidCard() {
        Carte testCarte = new CartePopularite("TestCard", 1, "Test Description", 0, 0, false);
        jeu.getJoueurActuel().addCarte(testCarte);
        List<String> result = controleur.jouerCarte("TestCard");
        assertNotNull(result, "Result should not be null");
        assertFalse(result.isEmpty(), "Result should not be empty");
        assertEquals(4, jeu.getJoueurActuel().getNbCarte(), "Card should be removed from the player's hand");
    }

    @Test
    void testJouerCarte_InvalidCard() {
        List<String> result = controleur.jouerCarte("InvalidCard");
        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "Result should contain one message");
        assertTrue(result.get(0).contains("Carte pas trouvée"), "Message should indicate the card was not found");
    }
}