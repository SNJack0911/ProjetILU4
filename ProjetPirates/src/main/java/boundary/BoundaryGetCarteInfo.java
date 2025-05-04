package boundary;

import controleur.ControleurGetCarteInfo;
import noyau.BasicCategorie;
import noyau.ICategorieCarte;

public class BoundaryGetCarteInfo {
    private ControleurGetCarteInfo controleurGetCarteInfo;

    public BoundaryGetCarteInfo(ControleurGetCarteInfo controleurGetCarteInfo) {
        this.controleurGetCarteInfo = controleurGetCarteInfo;
    }

    public String getDescription(String nomCarte){
        String description = controleurGetCarteInfo.getDescription(nomCarte);
        if (description.equals("Card not found")) {
            System.out.println("Erreur : nom carte invalide.");
        }
        return controleurGetCarteInfo.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        ICategorieCarte typeCarte = controleurGetCarteInfo.getTypeCarte(nomCarte);
        if (typeCarte == null) {
            System.out.println("Erreur : nom carte invalide.");
        }
        return typeCarte;
    }

    public BasicCategorie getZoneDepot(String nomCarte){
        BasicCategorie zoneDepot = controleurGetCarteInfo.getZoneDepotCarte(nomCarte);
        if (zoneDepot == null) {
            System.out.println("Erreur : nom carte invalide.");
        }
        return zoneDepot;
    }

    public int getCarteId(String nomCarte) {
        int id = controleurGetCarteInfo.getCarteID(nomCarte);
        if (id < 0 || id > 23) {
            System.out.println("Erreur : Carte n'as pas d'image associée ou nom carte invalide.");
            return -1;
        }
        return id;
    }

    public void printCarteInfo(String nomCarte){
        System.out.println("Carte : " + nomCarte);
        System.out.println("Description : " + getDescription(nomCarte));
        System.out.println("Type : " + getTypeCarte(nomCarte));
        System.out.println("Zone de depot : " + getZoneDepot(nomCarte));
    }
}
