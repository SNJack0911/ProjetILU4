package controleur;

import noyau.BasicCategorie;
import noyau.ICategorieCarte;
import noyau.Jeu;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ControleurIntegrationTest {

    private Jeu jeu;

    public ControleurIntegrationTest() {
        jeu = new Jeu(); // Initialisation du jeu
    }

    @Test
    void testGetPirateMain_AfterInitialization() {
        ControleurGetPirateInfo controleur = new ControleurGetPirateInfo(jeu);

        ArrayList<String> mainPirate1 = controleur.getPirateMain(0);
        assertNotNull(mainPirate1);
        assertTrue(mainPirate1.size() > 0, "La main du pirate 1 devrait avoir des cartes assignées");

        ArrayList<String> mainPirate2 = controleur.getPirateMain(1);
        assertNotNull(mainPirate2);
        assertTrue(mainPirate2.size() > 0, "La main du pirate 2 devrait avoir des cartes assignées");
    }

    @Test
    void testPiocherCarte() {
        ControleurPiocherCarte controleurPiocherCarte = new ControleurPiocherCarte(jeu);

        ArrayList<String> cartesTirees = controleurPiocherCarte.piocherCarte();

        assertNotNull(cartesTirees);
        assertTrue(cartesTirees.size() > 0, "La pioche de cartes ne devrait pas être vide");

        int initialPirate1HandSize = jeu.getPirate(0).getNbCarte();
        int initialPirate2HandSize = jeu.getPirate(1).getNbCarte();

        assertTrue(initialPirate1HandSize >= 4 && initialPirate1HandSize <= 5, "Pirate 1 devrait avoir entre 4 et 5 cartes");
        assertTrue(initialPirate2HandSize >= 4 && initialPirate2HandSize <= 5, "Pirate 2 devrait avoir entre 4 et 5 cartes");
    }


    @Test
    void testGetCarteInfo() {
        ControleurGetCarteInfo controleurGetCarteInfo = new ControleurGetCarteInfo(jeu);

        String description = controleurGetCarteInfo.getDescription("Plus1Pop");
        assertNotNull(description);
        assertFalse(description.isEmpty(), "La description de la carte ne devrait pas être vide");

        ICategorieCarte categorie = controleurGetCarteInfo.getTypeCarte("Plus1Pop");
        assertNotNull(categorie, "Type de carte devrait être récupéré pour Plus1Pop");

        BasicCategorie zone = controleurGetCarteInfo.getZoneDepotCarte("Plus1Pop");
        assertNotNull(zone, "Zone de dépôt devrait être récupérée pour Plus1Pop");
    }



}
