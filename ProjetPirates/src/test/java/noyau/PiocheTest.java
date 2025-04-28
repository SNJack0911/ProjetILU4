package noyau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PiocheTest {

    private Pioche pioche;
    private ArrayList<Carte> cartes;

    @BeforeEach
    void setUp() {
        cartes = new ArrayList<>();
        cartes.add(new CarteAttack("Attaque 1", 1, "Une attaque", 10, 20, -5, -10, false, false));
        cartes.add(new CarteDefense("Défense 1", 2, "Une défense", 15, 5, true));
        cartes.add(new CartePopularite("Popularité 1", 3, "Une popularité", 8, 12, false));
        pioche = new Pioche(cartes);
    }

    @Test
    void testEstVideInitiallyFalse() {
        assertFalse(pioche.estVide(), "La pioche ne devrait pas être vide au départ.");
    }

    @Test
    void testPiocherReducesSize() {
        int initialSize = cartes.size();
        Carte carte = pioche.piocher();

        assertNotNull(carte, "Carte piochée ne doit pas être null.");
        assertEquals(initialSize - 1, cartes.size(), "Le nombre de cartes devrait diminuer de 1.");
    }

    @Test
    void testEstVideAfterAllCardsPioched() {
        while (!pioche.estVide()) {
            Carte c = pioche.piocher();
            assertNotNull(c, "Chaque carte piochée devrait exister.");
        }
        assertTrue(pioche.estVide(), "La pioche devrait être vide après avoir tout pioché.");
    }

    @Test
    void testPiocherFromEmptyPiocheThrowsException() {
        while (!pioche.estVide()) {
            pioche.piocher();
        }
        assertThrows(IllegalStateException.class, () -> pioche.piocher(),
                "Piocher dans une pioche vide devrait lancer une exception.");
    }
}
