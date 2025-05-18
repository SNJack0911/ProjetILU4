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
import java.util.logging.Logger;

/**
 *
 * @author yannf et fanny
 */

public class BoundaryJeu {
    private final BoundaryJouerCarte boundaryJouerCarte;
    private final BoundaryNouvellePartie boundaryNouvellePartie;
    private final BoundaryPiocherCarte boundaryPiocherCarte;
    private final ControleurGetCarteInfo controleurGetCarteInfo;
    private final ControleurGetPirateInfo controleurGetPirateInfo;
    private final Scanner scanner = new Scanner(System.in);
    private String erreurCarte = "Erreur : nom carte invalide.";
    private String erreurPirate = "Erreur : Numero de pirates invalide choisir 0 ou 1";
    private String separateur = "---------------------------------------";
    
    Logger logger = Logger.getLogger(getClass().getName());

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
        	logger.info(erreurCarte);
        }
        return controleurGetCarteInfo.getDescription(nomCarte);
    }

    public ICategorieCarte getTypeCarte(String nomCarte){
        ICategorieCarte typeCarte = controleurGetCarteInfo.getTypeCarte(nomCarte);
        if (typeCarte == null) {
        	logger.info(erreurCarte);
        }
        return typeCarte;
    }

    public BasicCategorie getZoneDepot(String nomCarte){
        BasicCategorie zoneDepot = controleurGetCarteInfo.getZoneDepotCarte(nomCarte);
        if (zoneDepot == null) {
        	logger.info(erreurCarte);
        }
        return zoneDepot;
    }
    
    public int getCarteId(String nomCarte) {
        int id = controleurGetCarteInfo.getCarteID(nomCarte);
        if (id < 0 || id > 24) {
        	logger.info("Erreur : Carte n'as pas d'image associée ou nom carte invalide.");
            return -1;
        }
        return id;
    }

    public void printCarteInfo(String nomCarte){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BOLD = "\u001B[1m";
        ICategorieCarte categorieCarte = getTypeCarte(nomCarte);
        String ainsiColor = switch (categorieCarte) {
            case BasicCategorie.POPULARITE -> "\u001B[32m";
            case BasicCategorie.ATTAQUE -> "\u001B[31m";
            case ExtendCategorie.DEFENSE -> "\u001B[35m";
            case ExtendCategorie.EFFET -> "\u001B[33m";
            default -> "\u001B[34m";
        };

        System.out.println(ANSI_BOLD + ainsiColor + "Carte : " + nomCarte + ANSI_RESET);
        System.out.println("Description : " + getDescription(nomCarte));
        System.out.println("Type : " + ainsiColor + categorieCarte + ANSI_RESET);
        System.out.println("Zone de depot : " + getZoneDepot(nomCarte));
    }
    
    public String getPirateName(int pirateID) {
        String nomPirate = controleurGetPirateInfo.getNomPirate(pirateID);
        if (nomPirate.equals("Numero de pirates invalide choisir 0 ou 1")) {
        	System.out.println("Erreur : "+ nomPirate);
            return "";
        }
        return nomPirate;
    }

    public int getPirateHp(int pirateID) {
        int hp = controleurGetPirateInfo.getPirateHp(pirateID);
        if (hp < 0) {
        	logger.info(erreurPirate);
        }
        return hp;
    }

    public int getPiratePp(int pirateID) {
        int pp = controleurGetPirateInfo.getPiratePp(pirateID);
        if (pp < 0) {
        	logger.info(erreurPirate);
        }
        return pp;
    }

    public List<String> getPirateMain(int pirateID) {
        List<String> main = controleurGetPirateInfo.getPirateMain(pirateID);
        if (main == null) {
        	logger.info(erreurPirate);
            return new ArrayList<>();
        }
        return main;
    }
    
     public void printPirateInfo(int pirateID){
    	 logger.info("*********************************");
         String name = getPirateName(pirateID);
         name =  pirateID == 0 ? name + " : \t\t" : name + " : ";
         System.out.println("***  " + name + "\t  ***");
         logger.info("*********************************");
         System.out.println("HP : " + getPirateHp(pirateID) + "\t" +
                            "PP : " + getPiratePp(pirateID));
    }

    private void printMainPirate(int pirateID){
    	logger.info("Main : ");
        List<String> main = getPirateMain(pirateID);
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

    public boolean isNuit(){return boundaryNouvellePartie.isNuit();}

    public List<String> piocherCarte() {
        return boundaryPiocherCarte.piocherCarte();
    }

    public void nouveauJeu(){
    	logger.info("""
                La mer est vaste, mais pas assez pour deux légendes.
                \tLe capitaine Tobias Blackbeard, impitoyable, commande la Forsaken Fancy d'une main de fer
                et d’un cœur de feu. Son nom inspire la peur sur toute la Mer de Marona
                
                \tLe capitaine Jake Gibbs, rapide et tranchant, vogue à bord du Serpent des Tempêtes, ne\s
                laissant derrière lui que des murmures et des épaves.""");

        String choix;
        do {
        	 logger.info("""
                    Choisissez une des deux options suivantes pour commencer votre aventure :\s
                    \t (c) Vous êtes prêts à hisser les voiles et à mettre le cap vers le trésor.
                    \t (q) Vous souhaitez abandonner ce navire avant qu’il ne coule.""");
            choix = scanner.next();
        }while (!(choix.equals("c") || choix.equals("q") || choix.equals("C") || choix.equals("Q")));
        if (choix.equals("q") || choix.equals("Q")) {
        	logger.info("Au revoir.");
            return;
        }
        do {
            initNewGame();
            jouerPartie();
            logger.info("""
                    Choisissez une des deux options suivantes :\s
                    \t (_) Vous voulez continuer à naviguer sur les mers.
                    \t (q) La dernière aventure vous a suffi.""");
            choix = scanner.next();
        }while (!(choix.equals("q") || choix.equals("Q")));
    }

    public void jouerPartie(){
        List<String> res;
        do{
            int tour = getTour();
            if (boundaryNouvellePartie.isNuit()){
                printMoon();
            }else{
                printSun();
            }
            logger.info(separateur);
            printPirateInfo((tour+1)%2);
            logger.info("\n----------------------\n");
            printPirateInfo(tour%2);
            printCartePiocher();
            printMainPirate(tour%2);
            List<String> main = getPirateMain(tour%2);
            int carte = -1;
            String nomCarte = "";
            String choix = "";
            do {
                do {
                	logger.info("Choisissez le chiffre d'une carte de votre main : ");
                    if (!scanner.hasNextInt()) {
                    	logger.info("Entrée invalide. Veuillez entrer un chiffre.");
                        scanner.next();
                        continue;
                    }

                    carte = scanner.nextInt() - 1;
                    if (carte < 0 || carte >= main.size()) {
                    	System.out.println("Entrée invalide. Veuillez entrer un chiffre entre 1 et " + main.size() + ".");
                    }
                } while (carte < 0 || carte >= main.size());
                nomCarte = main.get(carte);
                printCarteInfo(nomCarte);
                logger.info("Appliquer l'effet ? (O/N)");
                choix = scanner.next();
            } while (!choix.equals("O"));
            res = boundaryJouerCarte.jouerCarte(main.get(carte));
            boundaryNouvellePartie.incrementerTour();
        }while((res.getLast()).equals("Pas de gagnant"));

    }

    private void printCartePiocher(){
    	logger.info(separateur);
        List<String> cartesPiocher = piocherCarte();
        logger.info("Carte(s) piochée(s) en début de tour : \n");
        for(String carte : cartesPiocher){
            printCarteInfo(carte);
        }
        logger.info(separateur);
    }

    private void printMoon() {
        logger.info("""
                Il fait nuit 
                                            .. '      *  
                  .   '.              .-.  +               *        
                               +     ( (       '                    
                  .      .:'          `-'         .          '      
                      *         ' *          *  *    .+     .'      
                     .   .              *      +                 *   
                """);
    }


    private void printSun (){
    	logger.info("""
    			Il fait jour
    											.-. .--
    						_   .				   (  +(	)
    					_( ) ),					  `-(	   )
    						(_.		.))					(_____(__))
    						  (__)___)
    				""");
    }

}
