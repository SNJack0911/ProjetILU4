/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;
import boundary.components.JCarte;
import controleur.ControleurGetCarteInfo;
import controleur.ControleurGetPirateInfo;
import noyau.BasicCategorie;
import noyau.ExtendCategorie;
import noyau.ICategorieCarte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author yannf et fanny
 */
/*
    Used to condense the amount of arguments given when creating a panel or a frame
 */
public class BoundaryJeu {
    private BoundaryJouerCarte boundaryJouerCarte;
    private BoundaryNouvellePartie boundaryNouvellePartie;
    private BoundaryPiocherCarte boundaryPiocherCarte;
    private ControleurGetCarteInfo controleurGetCarteInfo;
    private ControleurGetPirateInfo controleurGetPirateInfo;
    private Scanner scanner = new Scanner(System.in);

    public BoundaryJeu(BoundaryJouerCarte boundaryJouerCarte, BoundaryNouvellePartie boundaryNouvellePartie,
                       BoundaryPiocherCarte boundaryPiocherCarte, ControleurGetCarteInfo controleurGetCarteInfo, ControleurGetPirateInfo controleurGetPirateInfo) {
        this.boundaryJouerCarte = boundaryJouerCarte;
        this.boundaryNouvellePartie = boundaryNouvellePartie;
        this.boundaryPiocherCarte = boundaryPiocherCarte;
        this.controleurGetCarteInfo = controleurGetCarteInfo;
        this.controleurGetPirateInfo = controleurGetPirateInfo;
    }

    public String getDescription(String nomCarte){
        String description = controleurGetCarteInfo.getDescription(nomCarte);
        if (description.equals("Card not found")) {
            System.out.println("Erreur : nom carte invalide.");
        }
        return controleurGetCarteInfo.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        ICategorieCarte typeCarte = controleurGetCarteInfo.getTypeCarte(nomCarte);
        if (typeCarte == null) {
            System.out.println("Erreur : nom carte invalide.");
        }
        return typeCarte;
    }

    public BasicCategorie getZoneDepot(String nomCarte){
        BasicCategorie zoneDepot = controleurGetCarteInfo.getZoneDepotCarte(nomCarte);
        if (zoneDepot == null) {
            System.out.println("Erreur : nom carte invalide.");
        }
        return zoneDepot;
    }
    
    public int getCarteId(String nomCarte) {
        int id = controleurGetCarteInfo.getCarteID(nomCarte);
        if (id < 0 || id > 24) {
            System.out.println("Erreur : Carte n'as pas d'image associée ou nom carte invalide.");
            return -1;
        }
        return id;
    }

    public void printCarteInfo(String nomCarte){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BOLD = "\u001B[1m";
        ICategorieCarte categorieCarte = getTypeCarte(nomCarte);
        String ANSI_COLOR = switch (categorieCarte) {
            case BasicCategorie.POPULARITE -> "\u001B[32m";
            case BasicCategorie.ATTAQUE -> "\u001B[31m";
            case ExtendCategorie.DEFENSE -> "\u001B[35m";
            case ExtendCategorie.EFFET -> "\u001B[33m";
            default -> "\u001B[34m";
        };

        System.out.println(ANSI_BOLD + ANSI_COLOR + "Carte : " + nomCarte + ANSI_RESET);
        System.out.println("Description : " + getDescription(nomCarte));
        System.out.println("Type : " + ANSI_COLOR + categorieCarte + ANSI_RESET);
        System.out.println("Zone de depot : " + getZoneDepot(nomCarte));
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
    
     public void printPirateInfo(int pirateID){
         System.out.println("*********************************");
         System.out.println("***  " + getPirateName(pirateID) + " :\t  ***");
         System.out.println("*********************************");
        System.out.println("HP : " + getPirateHp(pirateID) + "\t" +
                            "PP : " + getPiratePp(pirateID));
    }

    private void printMainPirate(int pirateID){
        System.out.println("Main : ");
        ArrayList<String> main = getPirateMain(pirateID);
        for (int i = 0; i < main.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + main.get(i));
        }
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

    public void incrementerTour(){
        boundaryNouvellePartie.incrementerTour();
    }
    public ArrayList<String> piocherCarte() {
        return boundaryPiocherCarte.piocherCarte();
    }

    public void setNuit(Boolean isNuit){
        boundaryNouvellePartie.setNuit(isNuit);
    }
    

    public void JouerPartie(){
        initNewGame();
        List<String> res;
        do{
            int tour = getTour();
            printPirateInfo((tour+1)%2);
            System.out.println("\n----------------------\n");
            printPirateInfo(tour%2);
            printCartePiocher();
            printMainPirate(tour%2);
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
                printCarteInfo(nomCarte);
                System.out.println("Appliquer l'effet ? (O/N)");
                choix = scanner.next();
            } while (!choix.equals("O"));
            res = boundaryJouerCarte.jouerCarte(main.get(carte));
            boundaryNouvellePartie.incrementerTour();
        }while((res.getLast()).equals("Pas de gagnant"));

    }

    private void printCartePiocher(){
        System.out.println("---------------------------------------");
        ArrayList<String> cartesPiocher = piocherCarte();
        System.out.println("Carte(s) piochée(s) en début de tour : \n");
        for(String carte : cartesPiocher){
            printCarteInfo(carte);
        }
        System.out.println("---------------------------------------");
    }


}
