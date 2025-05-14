package noyau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/*
* @author Stefan
* */

class PiocheTest {

    private Pioche pioche;
    private ArrayList<Carte> cartes;

    @BeforeEach
    void setUp() {
        cartes = new ArrayList<>();
        cartes.add(new CarteAttack("A1", 1, "Une attaque", 10, 20, -5, -10, false, false));
        cartes.add(new CarteDefense("D1", 2, "Une défense", 15, 5, true));
        cartes.add(new CartePopularite("P1", 3, "Une popularité", 8, 12, false));
        pioche = new Pioche(new ArrayList<>(cartes));
    }

    @Test
    void testEstVideInitiallyFalse() {
        assertFalse(pioche.estVide(), "La pioche ne devrait pas être vide au départ.");
    }

    @Test
    void testPiocherReducesSize() {
        int sizeBefore = cartes.size();
        Carte p = pioche.piocher();

        assertNotNull(p, "Carte piochée ne doit pas être null.");
        assertEquals(sizeBefore - 1, pioche.getNbCartes(), "Le nombre de cartes devrait diminuer de 1.");
    }

    @Test
    void testEstVideAfterAllCardsPioched() {
        while (!pioche.estVide()) {
            Carte carte = pioche.piocher();
            assertNotNull(carte, "Chaque carte piochée devrait exister.");
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

    @Test
    void testBoundaryCaseSingleCard() {
        ArrayList<Carte> uneCarte = new ArrayList<>();
        uneCarte.add(new CarteDefense("Unique", 10, "Unique", 20, 5, false));
        Pioche piocheUnique = new Pioche(uneCarte);

        assertFalse(piocheUnique.estVide(), "La pioche avec une carte ne devrait pas être vide.");
        Carte p = piocheUnique.piocher();
        assertNotNull(p, "Carte piochée ne doit pas être null.");
        assertTrue(piocheUnique.estVide(), "La pioche devrait être vide après avoir pioché la seule carte.");
        assertThrows(IllegalStateException.class, piocheUnique::piocher,
                "Piocher une deuxième fois devrait lancer une exception.");
    }

    @Test
    void testNbCartesConsistentWithSize() {
        while (!pioche.estVide()) {
            pioche.piocher();
            assertEquals(pioche.getCartesSize(), pioche.getNbCartes(),
                    "Le compteur nbCartes doit être cohérent avec la taille réelle de la liste.");
        }
    }
}
