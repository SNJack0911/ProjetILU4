package noyau;

import java.util.ArrayList;

public class JeuDeCarte {
    private Configuration[] config = {new Configuration(new CartePopularite("Plus1Pop", -1, "Le joueur Gagne 1PP", 1, 0, false), 10),
            new Configuration(new CartePopularite("Moins1Pop", -1, "Le joueur Perd 1PP", -1, 0, false), 10),
            new Configuration(new CartePopularite("Plus1PV pop", -1, "Le joueur gagne 1PV", 0, 1, false), 10),
            new Configuration(new CarteAttack("Plus1PV att", -1, "Le joueur Gagne 1 PV Attaque", 0, 1, 0, 0, false, false), 10),
            new Configuration(new CarteAttack("Moins1PVA", -1, "L'adversaire perd 1 PV", 0, 0, 0, -1, false, false), 10),
            new Configuration(new CarteAttack("Moins1PPA", -1, "L'adversaire perd 1 PP", 0, 0, -1, 0, false, false), 10),
    };

   

    /* new Configuration(new CarteDefense("Ode à la Joie", 1, "Le joueur Gagne 3PV",3, 0, false), 7),
            new Configuration(new CarteDefense("Douceur ensoleillé", 2, "Gagne 1 PV, Gagne 1 PV de plus si le jour",1, 0, true), 13),
            new Configuration(new CarteAttack("Dans ta Face", 4, "Le joueur lance un pièce, tant que face, l'adversaire -1 PV",0, 0, 0, -1, false, true), 10),
            new Configuration(new CarteAttack("Peau de Banane", 8, "L'adversaire perds 1PP",0, 0, -1, 0, false, false), 16)


        {new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),new Configuration(new CarteAttack("1", "d", null), 0),
            new Configuration(new CarteAttack("1", "d", null), 0),};

            Carte c  = new Carte(nom, desc, type.EFFET) {
            @Override
            public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
                //unique effet
            }
        })*/

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

    private Carte getCarte(String nom){
        for (Configuration c : config){
            if (c.getCarte().getNom().equals(nom)){
                return c.getCarte();
            }
        }
        return null;
    }

    public String getDescription(String nom){
        Carte carte = getCarte(nom);
        if (carte != null){
            return carte.getDescription();
        }else {
            return "Card not found";
        }
    }

    public ICategorieCarte getCategorie(String nom){
        Carte carte = getCarte(nom);
        if (carte != null){
            return carte.getCategorie();
        }else {
            return null;
        }
    }

    public BasicCategorie getZoneDepot(String nom){
        Carte carte = getCarte(nom);
        if (carte != null){
            return carte.getZoneDepot();
        }else {
            return null;
        }
    }
    
     public int getCarteID(String nomCarte) {
        Carte carte = getCarte(nomCarte);
        if (carte != null){
            return carte.getCarteID();
        }else {
            return -1;
        }
         
    }
}
