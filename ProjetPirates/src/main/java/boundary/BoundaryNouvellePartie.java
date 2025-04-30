package boundary;

import controleur.ControleurNouvellePartie;

public class BoundaryNouvellePartie {
    private ControleurNouvellePartie controleurNouvellePartie;

    public BoundaryNouvellePartie(ControleurNouvellePartie controleurNouvellePartie) {
        this.controleurNouvellePartie = controleurNouvellePartie;
    }

    public void initNewGame(){
        System.out.println("Lancement d'une nouvelle partie");
        controleurNouvellePartie.lancerJeu();
    }

    public int getTour(){
        int tour = controleurNouvellePartie.getTour();
        if (tour < 0) {
            System.out.println("Erreur : Tour inexistant");
            return 0;
        }
        return tour;
    }
}
