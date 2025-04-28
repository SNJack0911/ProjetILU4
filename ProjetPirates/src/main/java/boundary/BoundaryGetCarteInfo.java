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
        return controleurGetCarteInfo.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        return controleurGetCarteInfo.getTypeCarte(nomCarte);
    }

    public BasicCategorie getZoneDepot(String nomCarte){
        return controleurGetCarteInfo.getZoneDepotCarte(nomCarte);
    }

    public int getCarteId(String nomCarte) {
        return controleurGetCarteInfo.getCarteID(nomCarte);
    }

    public void printCarteInfo(String nomCarte){
        System.out.println("Carte : " + nomCarte);
        System.out.println("Description : " + getDescription(nomCarte));
        System.out.println("Type : " + getTypeCarte(nomCarte));
        System.out.println("Zone de depot : " + getZoneDepot(nomCarte));
    }
}
