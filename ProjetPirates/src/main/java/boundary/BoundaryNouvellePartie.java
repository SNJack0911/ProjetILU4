package boundary;

import controleur.ControleurNouvellePartie;

public class BoundaryNouvellePartie {
    private ControleurNouvellePartie controleurNouvellePartie;

    public BoundaryNouvellePartie(ControleurNouvellePartie controleurNouvellePartie) {
        this.controleurNouvellePartie = controleurNouvellePartie;
    }

    public void initNewGame(){
        controleurNouvellePartie.lancerJeu();
    }

    public int getTour(){
        return controleurNouvellePartie.getTour();
    }
}
