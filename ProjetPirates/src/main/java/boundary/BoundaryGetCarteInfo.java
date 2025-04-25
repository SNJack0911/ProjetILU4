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
}
