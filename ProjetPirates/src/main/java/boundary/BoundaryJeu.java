/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;
import boundary.components.JCarte;
import noyau.BasicCategorie;
import noyau.ICategorieCarte;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yannf
 */
/*
    Used to condense the amount of arguments given when creating a panel or a frame
 */
public class BoundaryJeu {
    private BoundaryGetCarteInfo boundaryGetCarteInfo;
    private BoundaryGetPirateInfo boundaryGetPirateInfo;
    private BoundaryJouerCarte boundaryJouerCarte;
    private BoundaryNouvellePartie boundaryNouvellePartie;
    private BoundaryPiocherCarte boundaryPiocherCarte;

    public BoundaryJeu(BoundaryGetCarteInfo boundaryGetCarteInfo, BoundaryGetPirateInfo boundaryGetPirateInfo,
                       BoundaryJouerCarte boundaryJouerCarte, BoundaryNouvellePartie boundaryNouvellePartie,
                       BoundaryPiocherCarte boundaryPiocherCarte) {
        this.boundaryGetCarteInfo = boundaryGetCarteInfo;
        this.boundaryGetPirateInfo = boundaryGetPirateInfo;
        this.boundaryJouerCarte = boundaryJouerCarte;
        this.boundaryNouvellePartie = boundaryNouvellePartie;
        this.boundaryPiocherCarte = boundaryPiocherCarte;
    }

    public String getDescription(String nomCarte){
        return boundaryGetCarteInfo.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        return boundaryGetCarteInfo.getTypeCarte(nomCarte);
    }

    public BasicCategorie getZoneDepot(String nomCarte){
        return boundaryGetCarteInfo.getZoneDepot(nomCarte);
    }

    public String getPirateName(int pirateID) {
        return boundaryGetPirateInfo.getPirateName(pirateID);
    }

    public int getPirateHp(int pirateID) {
        return boundaryGetPirateInfo.getPirateHp(pirateID);
    }

    public int getPiratePp(int pirateID) {
        return boundaryGetPirateInfo.getPiratePp(pirateID);
    }

    public ArrayList<String> getPirateMain(int pirateID) {
        return boundaryGetPirateInfo.getPirateMain(pirateID);
    }

    public List<String> jouerCarte(JCarte carte) {
        return boundaryJouerCarte.jouerCarte(carte);
    }

    public void initNewGame(){
        boundaryNouvellePartie.initNewGame();
    }

    public int getTour(){
        return boundaryNouvellePartie.getTour();
    }

    public ArrayList<String> piocherCarte() {
        return boundaryPiocherCarte.piocherCarte();
    }

    public int getCarteId(String nomCarte) {
        return boundaryGetCarteInfo.getCarteId(nomCarte);
    }
}
