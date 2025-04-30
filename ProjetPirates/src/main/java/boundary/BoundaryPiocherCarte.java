package boundary;

import controleur.ControleurPiocherCarte;

import java.util.ArrayList;

public class BoundaryPiocherCarte {
    private ControleurPiocherCarte controleurPiocherCarte;

    public BoundaryPiocherCarte(ControleurPiocherCarte controleurPiocherCarte) {
        this.controleurPiocherCarte = controleurPiocherCarte;
    }

    public ArrayList<String> piocherCarte() {
        ArrayList<String> p = controleurPiocherCarte.piocherCarte();
        if (p == null || p.isEmpty()){
            System.out.println("Aucune carte n'a été piochée.");
        }
        return p;
    }
}
