package boundary;

import boundary.components.JCarte;
import controleur.ControleurJouerCarte;

import java.util.List;

public class BoundaryJouerCarte {
    private ControleurJouerCarte controleurJouerCarte;

    public BoundaryJouerCarte(ControleurJouerCarte controleurJouerCarte) {
        this.controleurJouerCarte = controleurJouerCarte;
    }


    public List<String> jouerCarte(JCarte carte) {
        return controleurJouerCarte.jouerCarte(carte.getNomCarte());
        //TODO traiter les evenements
        //Les evenements sont de la forme : ["0", "0", "1", "Pas de Gagnant"] //0 = pile et 1 = face
        //                                  ["1", "NomPirate1"]
        //                                  ["NomPirate2"]
        //TODO traitement fin de tour et changement de joueur
        //if (HasWinner){
        //  TODO
        //}else{
        //  plateau.flipAllCards()
        //}
    }
}
