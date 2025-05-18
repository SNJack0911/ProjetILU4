package boundary;

import controleur.ControleurPiocherCarte;

import java.util.List;

public class BoundaryPiocherCarte {
    private final ControleurPiocherCarte controleurPiocherCarte;

    public BoundaryPiocherCarte(ControleurPiocherCarte controleurPiocherCarte) {
        this.controleurPiocherCarte = controleurPiocherCarte;
    }

    public List<String> piocherCarte() {
        List<String> p = controleurPiocherCarte.piocherCarte();
        if (p == null || p.isEmpty()){
            System.out.println("Aucune carte n'a été piochée.");
        }
        return p;
    }
}
