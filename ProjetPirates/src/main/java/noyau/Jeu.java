package noyau;

import java.util.ArrayList;

public class Jeu {
    private Pirate joueur1;
    private Pirate joueur2;
    private Pioche pioche;
    private int tour;

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

    public String jouerCarte(String nomCarte){
        ArrayList<Carte> mainPirate;
        Carte carte;
        if(tour %2 == 0){
            mainPirate = joueur1.getMain();
            carte = getCarteMain(nomCarte, mainPirate);
            //Applique effet Carte
            joueur1.supprimerCarteMain(carte);
        } else {
            mainPirate = joueur2.getMain();
            carte = getCarteMain(nomCarte, mainPirate);
            //Applique effet Carte
            joueur1.supprimerCarteMain(carte);
        }
        tour++;
        return getGagnant();
    }

    public Carte getCarteMain(String nomCarte, ArrayList<Carte> mainPirate){
        for (Carte carte : mainPirate) {
            if (carte.getNom().equals(nomCarte)) {return carte;}
        }
        return null;
    }
}
