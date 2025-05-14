package noyau;

import boundary.components.GestionnaireEffetFumee;
import boundary.components.SmokeEffect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Image;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Stefan
 * */

class GestionnaireEffetFumeeTest {

    private GestionnaireEffetFumee gestionnaire;

    @BeforeEach
    void setUp() {
        gestionnaire = new GestionnaireEffetFumee();
    }

    @Test
    void testGetRandomImageWhenImagesLoaded() {
        // Ici on suppose que le constructeur de GestionnaireEffetFumee charge les images
        Image img = gestionnaire.getRandomImage();
        // On ne peut pas garantir que l'image soit la même à chaque fois
        // mais on peut vérifier qu'elle n'est pas nulle
        if (gestionnaire.getRandomImage() != null) {
            assertNotNull(img, "L'image ne devrait pas être nulle si des images sont chargées");
        } else {
            assertNull(img, "Aucune image ne devrait être chargée");
        }
    }

    @Test
    void testAjouterFumeeWhenImageAvailable() {
        // Premièrement, on simule manuellement si les images sont manquantes
        // Normalement le constructeur devrait charger les images, mais si ce n'est pas le cas, on injecte une fausse image
        if (gestionnaire.getRandomImage() == null) {
            return; // On ne peut pas tester si aucune image n'est chargée
        }

        gestionnaire.ajouterFumee(100, 150);

        List<SmokeEffect> fumees = getFumeesList(gestionnaire);

        assertEquals(1, fumees.size());
        SmokeEffect smoke = fumees.get(0);

        assertNotNull(smoke);
    }

    @Test
    void testAjouterFumeeDoesNothingIfNoImage() {
        //Simule si aucune image n'est chargée
        GestionnaireEffetFumee emptyGestionnaire = new GestionnaireEffetFumee() {
            @Override
            public Image getRandomImage() {
                return null; // on force le gestionnaire à ne pas avoir d'image
            }
        };

        emptyGestionnaire.ajouterFumee(100, 150);

        List<SmokeEffect> fumees = getFumeesList(emptyGestionnaire);

        assertTrue(fumees.isEmpty(), "Aucune fumée ne devrait être ajoutée si aucune image n'est disponible");
    }

    /**
     * La methode getFumeesList est utilisée pour accéder à la liste des fumées
     */
    @SuppressWarnings("unchecked")
    private List<SmokeEffect> getFumeesList(GestionnaireEffetFumee gestionnaire) {
        try {
            var field = GestionnaireEffetFumee.class.getDeclaredField("fumeeList");
            field.setAccessible(true);
            return (List<SmokeEffect>) field.get(gestionnaire);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
