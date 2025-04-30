package boundary;

import controleur.ControleurGetPirateInfo;

import java.util.ArrayList;

public class BoundaryGetPirateInfo {
    private ControleurGetPirateInfo controleurGetPirateInfo;

    public BoundaryGetPirateInfo(ControleurGetPirateInfo controleurGetPirateInfo) {
        this.controleurGetPirateInfo = controleurGetPirateInfo;
    }

    public String getPirateName(int pirateID) {
        String nomPirate = controleurGetPirateInfo.getNomPirate(pirateID);
        if (nomPirate.equals("Numero de pirates invalide choisir 0 ou 1")) {
            System.out.println("Erreur : " + nomPirate);
            return "";
        }
        return nomPirate;
    }

    public int getPirateHp(int pirateID) {
        int hp = controleurGetPirateInfo.getPirateHp(pirateID);
        if (hp < 0) {
            System.out.println("Erreur : Numero de pirates invalide choisir 0 ou 1");
        }
        return hp;
    }

    public int getPiratePp(int pirateID) {
        int pp = controleurGetPirateInfo.getPiratePp(pirateID);
        if (pp < 0) {
            System.out.println("Erreur : Numero de pirates invalide choisir 0 ou 1");
        }
        return pp;
    }

    public ArrayList<String> getPirateMain(int pirateID) {
        ArrayList<String> main = controleurGetPirateInfo.getPirateMain(pirateID);
        if (main == null) {
            System.out.println("Erreur : Numero de pirates invalide choisir 0 ou 1");
            return new ArrayList<>();
        }
        return main;
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
