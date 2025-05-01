
package noyau;

import java.util.ArrayList;
import java.util.List;

public class JeuNOUVELLE_PROPOSITION {
    private Pirate joueur1;
    private Pirate joueur2;
    private JeuDeCarte jeuDeCarte;
    private Pioche pioche;
    private int tour;
    private boolean nuit = false;

    public JeuNOUVELLE_PROPOSITION() {
        initJeu();
    }

    public void initJeu() {
        joueur1 = new Pirate("J1");
        joueur2 = new Pirate("J2");
        jeuDeCarte = new JeuDeCarte();
        pioche = new Pioche(jeuDeCarte.remplirPioche());
        tour = 0;
        for (int i = 0; i < 4; i++) {
            joueur1.addCarte(pioche.piocher());
            joueur2.addCarte(pioche.piocher());
        }
    }

    public Pirate getJoueurActuel() {
        return (tour % 2 == 0) ? joueur1 : joueur2;
    }

    public Pirate getAdversaireActuel() {
        return (tour % 2 == 0) ? joueur2 : joueur1;
    }

    public void incrementerTour() {
        tour++;
    }

    private boolean isJeuTermine() {
        return joueur1.getPP() == 5 || joueur2.getPP() == 5 ||
               joueur1.getHP() == 0 || joueur2.getHP() == 0;
    }

    public String getGagnant() {
        if (joueur1.getPP() >= 5 || joueur2.getHP() <= 0) {
            return joueur1.getNom();
        } else if (joueur2.getPP() >= 5 || joueur1.getHP() <= 0) {
            return joueur2.getNom();
        }
        return "Pas de gagnant";
    }

    public ArrayList<Carte> jouerPioche() {
        return piocherInf5(getJoueurActuel());
    }

    private ArrayList<Carte> piocherInf5(Pirate joueur) {
        ArrayList<Carte> cartesLst = new ArrayList<>();
        while (joueur.getNbCarte() < 5) {
            if (pioche.estVide()) {
                pioche = new Pioche(jeuDeCarte.remplirPioche());
            }
            try {
                Carte carte = pioche.piocher();
                joueur.addCarte(carte);
                cartesLst.add(carte);
            } catch (IllegalStateException e) {
                System.err.println("Erreur piocher carte : " + e.getMessage());
                break;
            }
        }
        return cartesLst;
    }
/*  // EN COMMENTAIRE POUR PAS FOUTRE LE BORDEL SI QUELQU'UN PULL. FAUDRA ENLEVER LES COMMENTAIRE
    // QUAND TU VA CHECK
    public List<String> jouerCarte(String nomCarte) {
        Pirate joueur = getJoueurActuel();
        Carte carte = joueur.getCarteMain(nomCarte);

        if (carte == null) {
            return List.of("Carte pas trouvée");
        }

        Pirate adversaire = getAdversaireActuel();
        List<String> resultatTour = carte.appliquerEffet(joueur, adversaire, this); 
            //Ici c'est parce que c'est pas jeu mais JeuNOUVELLE_Proposition
        joueur.supprimerCarteMain(carte);

        incrementerTour();
        resultatTour.add(getGagnant());
        return resultatTour;
    }
*/
    public boolean isNuit() {
        return nuit;
    }

    public void setNuit(boolean nuit) {
        this.nuit = nuit;
    }

    public JeuDeCarte getJeuDeCarte() {
        return jeuDeCarte;
    }

    public Pirate getPirate(int numero) {
        return (numero == 0) ? joueur1 : (numero == 1) ? joueur2 : null;
    }

    public int getTour() {
        return tour;
    }

    public boolean estJeuTermine() {
        return isJeuTermine();
    }
}
