package noyau;

public class CarteNuitPopularite extends CartePopulariteLambda{

    public CarteNuitPopularite(String nom, int carteID, String description, ICategorieCarte categorie,
                               IEffet effetPPJ, IEffet effetHPJ) {
        super(nom, carteID, description, categorie, effetPPJ, effetHPJ);
    }

    /*@Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        int newPPJ = 0;
        int newHPJ = 0;
        int newPPA = 0;
        int newHPA = 0;

        if(statNuit.equals("PP")){
            if (effetPPJ != null) newPPJ = effetPPJ.newValue(joueur, jeu)+1;
            if (effetPPA != null) newPPA = effetPPA.newValue(adversaire, jeu)+1;
        } else if (statNuit.equals("HP")) {
            if (effetHPJ != null) newHPJ = effetHPJ.newValue(joueur, jeu)+1;
            if (effetHPA != null) newHPA = effetHPA.newValue(adversaire, jeu)+1;
        }
        appliquerEffetJoueur(joueur, adversaire, newPPJ, newHPJ, newPPA, newHPA);
        return new ArrayList<>();
    }*/

    @Override
    protected void appliquerEffetJoueur(Pirate joueur, Pirate adversaire, Jeu jeu, int newPPJ, int newHPJ) {
        if (!jeu.isNuit()){
            super.appliquerEffetJoueur(joueur, adversaire, jeu, newPPJ, newHPJ +1);
        }else {
            super.appliquerEffetJoueur(joueur, adversaire, jeu, newPPJ, newHPJ);
        }
    }
}
