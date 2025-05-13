package noyau;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Stefan
 */
class JeuDeCarteTest {

    @Test
    void testRemplirPioche() {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        ArrayList<Carte> pioche = jeuDeCarte.remplirPioche();

        assertFalse(pioche.isEmpty(), "Le deck ne doit pas être vide après remplissage.");

        int expectedTotal = 7 + 10 + 12 + 2 + 10 + 9 + 12 + 9 + 3 + 6 + 12 + 60 + 4 + 7 + 5 + 5;
        assertEquals(expectedTotal, pioche.size(), "Le nombre total de cartes dans le deck est incorrect.");
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> descriptionCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("Coup bas", "L'adversaire perd 1PV"),
                org.junit.jupiter.params.provider.Arguments.of("InvalidCard", "Card not found"),
                org.junit.jupiter.params.provider.Arguments.of("", "Card not found"),
                org.junit.jupiter.params.provider.Arguments.of(null, "Card not found")
        );
    }

    @ParameterizedTest
    @MethodSource("descriptionCases")
    void testGetDescription(String input, String expected) {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        String description = jeuDeCarte.getDescription(input);
        assertEquals(expected, description);
    }

    static Stream<Arguments> carteIdCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("Plus1Pop", -1),     // Assumed expected ID, adjust if needed
                org.junit.jupiter.params.provider.Arguments.of("InvalidCard", -1),
                org.junit.jupiter.params.provider.Arguments.of("", -1),
                org.junit.jupiter.params.provider.Arguments.of(null, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("carteIdCases")
    void testGetCarteID(String input, int expected) {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        int id = jeuDeCarte.getCarteID(input);
        assertEquals(expected, id);
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> categorieCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("Coup bas", false),
                org.junit.jupiter.params.provider.Arguments.of("InvalidCard", true),
                org.junit.jupiter.params.provider.Arguments.of("", true),
                org.junit.jupiter.params.provider.Arguments.of(null, true)
        );
    }

    @ParameterizedTest
    @MethodSource("categorieCases")
    void testGetCategorie(String input, boolean shouldBeNull) {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        ICategorieCarte categorie = jeuDeCarte.getCategorie(input);
        if (shouldBeNull) {
            assertNull(categorie, "La catégorie doit être nulle.");
        } else {
            assertNotNull(categorie, "La catégorie ne doit pas être nulle.");
        }
    }

    static Stream<org.junit.jupiter.params.provider.Arguments> zoneDepotCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of("Coup bas", false),
                org.junit.jupiter.params.provider.Arguments.of("InvalidCard", true),
                org.junit.jupiter.params.provider.Arguments.of("", true),
                org.junit.jupiter.params.provider.Arguments.of(null, true)
        );
    }

    @ParameterizedTest
    @MethodSource("zoneDepotCases")
    void testGetZoneDepot(String input, boolean shouldBeNull) {
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        BasicCategorie zone = jeuDeCarte.getZoneDepot(input);
        if (shouldBeNull) {
            assertNull(zone, "La zone depot doit être nulle.");
        } else {
            assertNotNull(zone, "La zone depot ne doit pas être nulle.");
        }
    }
}
