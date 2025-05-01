package noyau;

import boundary.components.JCarte;
import boundary.components.JZoneInteractionCreux;
import java.util.ArrayList;
import java.util.List;

/**
 * Désué, servait pour l'ihm au tout début, remplacé par d'autres versions 
 * @author leo
 */

public class GestionnaireCartesCreux {

    private final List<JCarte> cartes = new ArrayList<>();
    private final List<JZoneInteractionCreux> zones = new ArrayList<>();

    public void ajouterCarte(JCarte carte) {
        cartes.add(carte);
    }

    public void ajouterZone(JZoneInteractionCreux zone) {
        zones.add(zone);
    }

    public void verifierToutesZones(JCarte carte) {
        for (JZoneInteractionCreux zone : zones) {
            zone.verifierCarte(carte); // délégué à la zone
        }
    }

    public List<JCarte> getCartes() {
        return cartes;
    }

    public List<JZoneInteractionCreux> getZones() {
        return zones;
    }

/*    
    public void affecterEffetTrainée(Carte_ carte) {
        int x = carte.getX();
        int y = carte.getY();

        carte.laisserTrainée(x, y);
    }
*/
}
