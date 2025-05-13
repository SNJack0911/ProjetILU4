package noyau;

import noyau.carteeffet.*;

import java.util.ArrayList;

/**
 *N
 * @author yannf
 */

public class JeuDeCarte {

    private final Configuration[] config = {
            new Configuration(new CarteDefenseLambda("Ode à la Joie", 1, "Le joueur Gagne 3PV", (p, j) -> p.getHP()+3),7),
            new Configuration(new CarteDefenseLambda("Douceur ensoleillée", 2, "Le Joueur Gagne 1 PV, Gagne 1 PV de plus si le jour",  (p, j) -> p.getHP()+1), 10),
            new Configuration(new CarteDefenseLambda("Hymne à Flute", 3, "Le joueur Gagne 1PV", (p, j) -> p.getHP()+1), 12),
            new Configuration(new CartePieceAttaque("Dans ta Face", 4, "Le joueur lance un pièce, tant que face, l'adversaire -1 PV",null, (p, j) -> p.getHP()-1), 2),
            new Configuration(new CarteNuitAttaque("Fureur de la nuit", 5, "Inflige -1 PV à l'adversaire, Inflige -1 PV de plus si la nuit", null, (p, j) -> p.getHP()-1), 10),
            new Configuration(new CarteAttaqueLambda("Kamikaze", 6, "Inflige 2 PV à l'adversaire. Inflige 1 PV à soi-même",
                    (pirate, jeu) -> pirate.getHP()-1, ((pirate, jeu) -> pirate.getHP()-2)), 9),
            new Configuration(new CarteAttaqueLambda("Coup bas", 7, "L'adversaire perd 1PV", null, (p, j) -> p.getHP()-1), 12),
            new Configuration(new CartePopulariteLambda("Le malade imaginaire", 9, "Le joueur Gagne 2PP mais perd 1PV", BasicCategorie.POPULARITE,
                    (pirate, jeu) -> pirate.getPP()+2, (pirate, jeu) -> pirate.getHP()-1), 9),
            new Configuration(new CartePiecePopularite("La chance du joueur", 10, "Le joueur lance un pièce, tant que pile, il gagne +1 PP", BasicCategorie.POPULARITE,
                    ((pirate, jeu) -> pirate.getPP()+1), null), 3),
            new Configuration(new CartePopulariteLambda("Invité au banquet", 12, "Le joueur Gagne 2 PP", BasicCategorie.POPULARITE,
                    ((pirate, jeu) -> pirate.getPP()+2), null), 6),
            new Configuration(new CartePopulariteLambda("Tournée de rhum", 23, "Le joueur Gagne 1PP", BasicCategorie.POPULARITE,
                    ((pirate, jeu) -> pirate.getPP()+1), null), 12),
            new Configuration(new CarteToucheEncre(), 60), //Quantite 6
            new Configuration(new CarteEffetAmplificateur(), 4),
            new Configuration(new CarteSourdOreille(), 7),
            new Configuration(new CarteAntidouleur(), 5),
            new Configuration(new CartePiedMarin(), 5)
    };

    private static class Configuration{
        Carte carte;
        int quantite;


        private Configuration(Carte carte, int quantite){
            this.carte = carte;
            this.quantite = quantite;
        }

        private Carte getCarte(){return carte;}

        private int getQuantite(){return quantite;}
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
