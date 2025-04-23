package boundary;

import controleur.ControleurPiocherCarte;

import java.util.ArrayList;

public class BoundaryPiocherCarte {
    private ControleurPiocherCarte controleurPiocherCarte;

    public BoundaryPiocherCarte(ControleurPiocherCarte controleurPiocherCarte) {
        this.controleurPiocherCarte = controleurPiocherCarte;
    }

    public ArrayList<String> piocherCarte() {
        return controleurPiocherCarte.piocherCarte();
        //TODO Ajouter les cartes à la main
        //Les cartes sont de la forme nom et il faut get les attribut
        // NON VALIDE -> Les cartes sont de la forme ["nom", ICategorieCarte type, "Description", BasicCategorie zoneDepot]
        //plateau.ajouterCartes(1 ou 2, cartes)
    }
}
