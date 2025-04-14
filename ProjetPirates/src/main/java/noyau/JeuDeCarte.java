package noyau;

import java.util.ArrayList;

public class JeuDeCarte {
    private Configuration[] config = {new Configuration(new CarteDefense("Ode à la Joie", "Le joueur Gagne 3PV",3, 0, false ), 7),
            new Configuration(new CarteDefense("Douceur ensoleillé", "Gagne 1 PV, Gagne 1 PV de plus si le jour",1, 0, true ), 13)};






        /*{new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),};

            new Carte() {
            @Override
            public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {

            }
        })
            */

    private static class Configuration{
        Carte carte;
        int quantite;


        private Configuration(Carte carte, int quantite){
            this.carte = carte;
            this.quantite = quantite;
        }

        private Carte getCarte(){return carte;};

        private int getQuantite(){return quantite;};
    }

    public ArrayList<Carte> remplirPioche(){
        ArrayList<Carte> cartes = new ArrayList<>();
        Carte carte;
        for (Configuration c : config){
            carte = c.getCarte();
            for (int i= 0; i < c.getQuantite(); i++) {
                cartes.add(carte);
            }
        }
        return cartes;
    }
}
