package boundary.component_manager;

import boundary.components.JCarte;
import boundary.components.Zone_d_interaction;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireCartes {

    private final List<JCarte> cartes = new ArrayList<>();
    private final List<Zone_d_interaction> zones = new ArrayList<>();

    public void ajouterCarte(JCarte carte) {
        cartes.add(carte);
    }

    public void ajouterZone(Zone_d_interaction zone) {
        zones.add(zone);
    }

    public void verifierToutesZones(JCarte carte) {
        for (Zone_d_interaction zone : zones) {
            zone.verifierCarte(carte); // délégué à la zone
        }
    }

    public List<JCarte> getCartes() {
        return cartes;
    }

    public List<Zone_d_interaction> getZones() {
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
