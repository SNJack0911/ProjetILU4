package noyau;

import boundary.components.JCarte;
import boundary.components.JZoneInteraction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GestionnaireCartesTest {

    private GestionnaireCartesCreux gestionnaire;

    @BeforeEach
    void setUp() {
        gestionnaire = new GestionnaireCartesCreux();
    }

    @Test
    void testAjouterCarte() {
        JCarte carte = new JCarte();
        gestionnaire.ajouterCarte(carte);

        List<JCarte> cartes = gestionnaire.getCartes();
        assertEquals(1, cartes.size());
        assertTrue(cartes.contains(carte));
    }

    @Test
    void testAjouterZone() {
        JZoneInteraction zone = new JZoneInteraction() {
            @Override
            public void verifierCarte(JCarte carte) {
                // Implementation pour le test
            }
        };
        gestionnaire.ajouterZone(zone);

        List<JZoneInteraction> zones = gestionnaire.getZones();
        assertEquals(1, zones.size());
        assertTrue(zones.contains(zone));
    }

    @Test
    void testVerifierToutesZones() {
        JCarte carte = new JCarte();

        class TestZone extends JZoneInteraction {
            int verificationCount = 0;

            @Override
            public void verifierCarte(JCarte carte) {
                verificationCount++;
            }
        }

        TestZone zone1 = new TestZone();
        TestZone zone2 = new TestZone();

        gestionnaire.ajouterZone(zone1);
        gestionnaire.ajouterZone(zone2);

        gestionnaire.verifierToutesZones(carte);

        assertEquals(1, zone1.verificationCount);
        assertEquals(1, zone2.verificationCount);
    }

    @Test
    void testGetCartesInitiallyEmpty() {
        assertTrue(gestionnaire.getCartes().isEmpty());
    }

    @Test
    void testGetZonesInitiallyEmpty() {
        assertTrue(gestionnaire.getZones().isEmpty());
    }
}
