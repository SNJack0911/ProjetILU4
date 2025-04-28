package boundary;

import controleur.ControleurGetPirateInfo;

import java.util.ArrayList;

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

    public ArrayList<String> getPirateMain(int pirateID) {
        return controleurGetPirateInfo.getPirateMain(pirateID);
    }

    public void printPirateInfo(int pirateID, boolean isAdversaire){
        System.out.println("Pirate : " + getPirateName(pirateID));
        System.out.println("HP : " + getPirateHp(pirateID));
        System.out.println("PP : " + getPiratePp(pirateID));
        if (!isAdversaire) {
            System.out.println("Main : ");
            ArrayList<String> main = getPirateMain(pirateID);
            for (int i = 0; i < main.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + main.get(i));
            }
        }
    }
}
