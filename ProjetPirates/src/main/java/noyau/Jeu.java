package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Jeu {
    private Pirate joueur1;
    private Pirate joueur2;
    private Pioche pioche;
    private int tour;
    private boolean nuit=false;
    private Map<Carte, Integer> carteNonJouer = new TreeMap<Carte, Integer>();

    public Jeu(){
        initJeu();
    }

    public void initJeu() {
        joueur1 = new Pirate("J1");
        joueur2 = new Pirate("J2");
        pioche = new Pioche(new JeuDeCarte().remplirPioche());
        tour = 0;
        for(int i =0; i<4; i++){
            joueur1.addCarte(pioche.piocher());
            joueur2.addCarte(pioche.piocher());
        }
    }

    private boolean isJeuTermine(){
        return joueur1.getPP() == 5 || joueur2.getPP() == 5 ||
               joueur1.getHP() == 0 || joueur2.getHP() == 0;
    }

    //not == but >=
    private String getGagnant(){
        if (joueur1.getPP() >= 5 || joueur2.getHP() >= 0){
            return joueur1.getNom();
        } else if (joueur2.getPP() >= 5 || joueur1.getHP() >= 0){
            return joueur2.getNom();
        }
        return "Pas de gagnant";
    }

    public ArrayList<Carte> jouerPioche(){
        ArrayList<Carte> cartesLst;
        if(tour %2 == 0){
            cartesLst = piocherInf5(joueur1);
        }else {
            cartesLst = piocherInf5(joueur2);
        }
        return cartesLst;
    }

    //Renvoyer un joueur si les cartes ne sont pas ajouter à la main du joueur
    private ArrayList<Carte> piocherInf5(Pirate joueur){
        Carte carte;
        ArrayList<Carte> cartesLst = new ArrayList<>();
        while (joueur.getNbCarte()<5){
            if (pioche.estVide()){
                pioche = new Pioche(new JeuDeCarte().remplirPioche());
            }
            carte = pioche.piocher();
            joueur.addCarte(carte);
            cartesLst.add(carte);
        }
        return cartesLst;
    }

    //Update String return
    public List<String> jouerCarte(String nomCarte){
        List<String> resutatTour;
        Carte carte;
        if(tour %2 == 0){
            /*mainPirate = joueur1.getMain();
            carte = getCarteMain(nomCarte, mainPirate);*/
            carte = joueur1.getCarteMain(nomCarte);
            resutatTour = carte.appliquerEffet(joueur1, joueur2, this);
            joueur1.supprimerCarteMain(carte);
        } else {
            /*mainPirate = joueur2.getMain();
            carte = getCarteMain(nomCarte, mainPirate);*/
            carte = joueur2.getCarteMain(nomCarte);
            resutatTour = carte.appliquerEffet(joueur2, joueur1, this);
            joueur2.supprimerCarteMain(carte);
        }
        tour++;
        resutatTour.add(getGagnant());
        return resutatTour;
    }

    //Same Function in Pirate
    /*public Carte getCarteMain(String nomCarte, ArrayList<Carte> mainPirate){
        for (Carte carte : mainPirate) {
            if (carte.getNom().equals(nomCarte)) {return carte;}
        }
        return null;
    }*/

    public boolean isNuit() {
        return nuit;
    }

    public void setNuit(boolean nuit) {
        this.nuit = nuit;
    }
}
