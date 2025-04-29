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
import java.util.Scanner;

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
    private Scanner scanner = new Scanner(System.in);

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
        return boundaryJouerCarte.jouerCarte(carte.getNomCarte());
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

    public void JouerPartie(){
        initNewGame();
        List<String> res;
        do{
            int tour = getTour();
            System.out.println("**********************");
            System.out.println("***  Adversaire :  ***");
            System.out.println("**********************");
            boundaryGetPirateInfo.printPirateInfo((tour+1)%2, true);
            System.out.println("---------------------------------------");
            ArrayList<String> cartesPiocher = piocherCarte();
            System.out.println("Carte(s) piochée(s) en début de tour : \n");
            for(String carte : cartesPiocher){
                boundaryGetCarteInfo.printCarteInfo(carte);
            }
            System.out.println("---------------------------------------");
            System.out.println("**********************");
            System.out.println("***  Joueur :      ***");
            System.out.println("**********************");
            boundaryGetPirateInfo.printPirateInfo(tour%2, false);
            ArrayList<String> main = getPirateMain(tour%2);
            int carte = -1;
            String nomCarte = "";
            String choix = "";
            do {
                do {
                    System.out.println("Choisissez le chiffre d'une carte de votre main : ");
                    carte = scanner.nextInt() - 1;
                } while (carte >= main.size());
                nomCarte = main.get(carte);
                boundaryGetCarteInfo.printCarteInfo(nomCarte);
                System.out.println("Appliquer l'effet ? (O/N)");
                choix = scanner.next();
            } while (!choix.equals("O"));
            res = boundaryJouerCarte.jouerCarte(main.get(carte));
        }while((res.getLast()).equals("Pas de gagnant"));

    }


}
