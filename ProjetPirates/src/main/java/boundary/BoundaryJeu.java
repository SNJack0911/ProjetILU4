/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;
import boundary.components.JCarte;
import controleur.*;

import java.util.ArrayList;

/**
 *
 * @author yannf
 */
public class BoundaryJeu {
    private ControleurLancerJeu controleurLancerJeu;
    private ControleurPiocherCarte controleurPiocherCarte;
    private ControleurJouerCarte controleurJouerCarte;

    /*private FrameJeu frameJeu;
    private Plateau plateau;*/

    public BoundaryJeu(ControleurLancerJeu controleurLancerJeu, ControleurPiocherCarte controleurPiocherCarte,
                       ControleurJouerCarte controleurJouerCarte) {
        /*this.frameJeu = frameJeu;
        this.plateau = frameJeu.getPlateau();*/ //Est-ce qu'il faut tous faire dans plateau ???
        this.controleurLancerJeu = controleurLancerJeu;
        this.controleurPiocherCarte = controleurPiocherCarte;
        this.controleurJouerCarte = controleurJouerCarte;
        //plateau.setBoundaryJeu(this);
    }

    public void lancerJeu() {
        controleurLancerJeu.lancerJeu();
    }

    public ArrayList<String[]> piocherCarte() {
        return controleurPiocherCarte.piocherCarte();
        //TODO Ajouter les cartes à la main
        //Les cartes sont de la forme ["nom", ICategorieCarte type, "Description", BasicCategorie zoneDepot]
        //plateau.ajouterCartes(1 ou 2, cartes)
    }

    public ArrayList<String> jouerCarte(JCarte carte) {
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
