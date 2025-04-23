package boundary;

import controleur.ControleurGetPirateInfo;

public class BoundaryGetPirateInfo {
    private ControleurGetPirateInfo controleurGetPirateInfo;

    public BoundaryGetPirateInfo(ControleurGetPirateInfo controleurGetPirateInfo) {
        this.controleurGetPirateInfo = controleurGetPirateInfo;
    }

    public String getPirateName(int pirateID) {
        //TODO traiter ID faux
        return controleurGetPirateInfo.getNomPirate(pirateID);
    }

    public int getPirateHp(int pirateID) {
        //TODO traiter ID faux
        return controleurGetPirateInfo.getPirateHp(pirateID);
    }

    public int getPiratePp(int pirateID) {
        //TODO traiter ID faux
        return controleurGetPirateInfo.getPiratePp(pirateID);
    }

}
