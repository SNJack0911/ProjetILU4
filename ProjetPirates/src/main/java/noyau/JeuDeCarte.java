package noyau;

import noyau.carteeffet.*;

import java.util.ArrayList;

/**
 *
 * @author yannf
 */

public class JeuDeCarte {
    private Configuration[] configOld = {new Configuration(new CarteDefense("Ode à la Joie", 1, "Le joueur Gagne 3PV",3, 0, false), 7),
            new Configuration(new CarteDefense("Douceur ensoleillé", 2, "Le Joueur Gagne 1 PV, Gagne 1 PV de plus si le jour",1, 0, true), 10),
            new Configuration(new CarteDefense("Hymne à Flute", 3, "Le joueur Gagne 1PV",1, 0, false), 12),
            new Configuration(new CarteAttack("Dans ta Face", 4, "Le joueur lance un pièce, tant que face, l'adversaire -1 PV",0, 0, 0, -1, false, true), 2),
            new Configuration(new CarteAttack("Fureur de la nuit", 5, "Inflige -1 PV à l'adversaire, Inflige -1 PV de plus si la nuit",0, 0, 0, -1, true, false), 10),
            new Configuration(new CarteAttack("Kamikaze", 6, "Inflige 2 PV à l'adversaire. Inflige 1 PV à soi-même",0, -1, 0, -2, false, false), 9),
            new Configuration(new CarteAttack("Coup bas", 7, "L'adversaire perds 1PV",0, 0, 0, -1, false, false), 12),
            new Configuration(new CarteAttack("Peau de Banane", 8, "L'adversaire perds 1PP",0, 0, -1, 0, false, false), 12),
            //new Configuration(new CarteAttack("Tout pour tout", 11, "L'adversaire perds 3PV, si il survi, il gagne 3PP", 0, 0, 0, -3, false, false ), 4),
            new Configuration(new CartePopularite("Le malade imaginaire", 9, "Le joueur Gagne 2PP mais perd 1PV", 2, -1, false), 9),
            new Configuration(new CartePopularite("La chance du joueur", 10, "Le joueur lance un pièce, tant que face, il gagne +1 PP", 1, 0, true), 3),
            new Configuration(new CartePopularite("Invité au banquet", 12, "Le joueur Gagne 2 PP", 2, 0, false), 8),
            new Configuration(new CartePopularite("Tournée de rhum", 23, "Le joueur Gagne 1PP", 1, 0, false), 16)
    };

    private Configuration[] config = {
            new Configuration(new CarteDefenseLambda("Ode à la Joie", 1, "Le joueur Gagne 3PV", (p, j) -> p.getHP()+3),7),
            new Configuration(new CarteDefenseLambda("Douceur ensoleillé", 2, "Le Joueur Gagne 1 PV, Gagne 1 PV de plus si le jour",  (p, j) -> p.getHP()+1), 10),
            new Configuration(new CarteDefenseLambda("Hymne à Flute", 3, "Le joueur Gagne 1PV", (p, j) -> p.getHP()+1), 12),
            new Configuration(new CartePieceAttaque("Dans ta Face", 4, "Le joueur lance un pièce, tant que face, l'adversaire -1 PV",null, (p, j) -> p.getHP()-1), 2),
            new Configuration(new CarteNuitAttaque("Fureur de la nuit", 5, "Inflige -1 PV à l'adversaire, Inflige -1 PV de plus si la nuit", null, (p, j) -> p.getHP()-1), 10),
            new Configuration(new CarteAttaqueLambda("Kamikaze", 6, "Inflige 2 PV à l'adversaire. Inflige 1 PV à soi-même",
                    (pirate, jeu) -> pirate.getHP()-1, ((pirate, jeu) -> pirate.getHP()-2)), 9),
            new Configuration(new CarteAttaqueLambda("Coup bas", 7, "L'adversaire perds 1PV", null, (p, j) -> p.getHP()-1), 12),
            new Configuration(new CartePopulariteLambda("Le malade imaginaire", 9, "Le joueur Gagne 2PP mais perd 1PV", BasicCategorie.POPULARITE,
                    (pirate, jeu) -> pirate.getPP()+2, (pirate, jeu) -> pirate.getHP()-1), 9),
            new Configuration(new CartePiecePopularite("La chance du joueur", 10, "Le joueur lance un pièce, tant que pile, il gagne +1 PP", BasicCategorie.POPULARITE,
                    ((pirate, jeu) -> pirate.getPP()+1), null), 40), //Quantité = 3
            new Configuration(new CartePiecePopularite("Invité au banquet", 12, "Le joueur Gagne 2 PP", BasicCategorie.POPULARITE,
                    ((pirate, jeu) -> pirate.getPP()+2), null), 6),
            new Configuration(new CartePopulariteLambda("Tournée de rhum", 23, "Le joueur Gagne 1PP", BasicCategorie.POPULARITE,
                    ((pirate, jeu) -> pirate.getPP()+1), null), 12),
            new Configuration(new CarteToucheEncre(), 6),
            new Configuration(new CarteEffetAmplificateur(), 4),
            new Configuration(new CarteSourdOreille(), 7),
            new Configuration(new CarteAntidouleur(), 5),
            new Configuration(new CartePiedMarin(), 5)

    };

    private Configuration[] testCards = {new Configuration(new CartePopularite("Plus1Pop", -1, "Le joueur Gagne 1PP", 1, 0, false), 10),
            new Configuration(new CartePopularite("Moins1Pop", -1, "Le joueur Perd 1PP", -1, 0, false), 10),
            new Configuration(new CartePopularite("Plus1PV pop", -1, "Le joueur gagne 1PV", 0, 1, false), 10),
            new Configuration(new CarteAttack("Plus1PV att", -1, "Le joueur Gagne 1 PV Attaque", 0, 1, 0, 0, false, false), 10),
            new Configuration(new CarteAttack("Moins1PVA", -1, "L'adversaire perd 1 PV", 0, 0, 0, -1, false, false), 10),
            new Configuration(new CarteAttack("Moins1PPA", -1, "L'adversaire perd 1 PP", 0, 0, -1, 0, false, false), 10),
    };

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

    public ArrayList<Carte> remplirPiocheTest(){
        ArrayList<Carte> cartes = new ArrayList<>();
        Carte carte;
        for (Configuration c : testCards){
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
