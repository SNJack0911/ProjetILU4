package noyau;

import boundary.components.JCarte;
import boundary.components.JZoneInteraction;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireCartes {

    private final List<JCarte> cartes = new ArrayList<>();
    private final List<JZoneInteraction> zones = new ArrayList<>();

    public void ajouterCarte(JCarte carte) {
        cartes.add(carte);
    }

    public void ajouterZone(JZoneInteraction zone) {
        zones.add(zone);
    }

    public void verifierToutesZones(JCarte carte) {
        for (JZoneInteraction zone : zones) {
            zone.verifierCarte(carte); // délégué à la zone
        }
System.out.println("Nombre de zones enregistrées : " + zones.size());

    }

    public List<JCarte> getCartes() {
        return cartes;
    }

    public List<JZoneInteraction> getZones() {
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
