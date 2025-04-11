package noyau;

import java.util.*;

public class Pirate {
    private int HP;
    private int PP;
    private String nom;
    private final ArrayList<Carte> hands = new ArrayList<>() ;
    public Pirate(String nom) {
        this.HP = 5;
        this.PP = 0;
        this.nom = nom;
    }

    public int getHP() {
        return HP;
    }

    /* HP > 0 = ajouter des HP 
       HP < 0 = enlever des HP
    */
    public void addHP(int value) {
        int newHP = HP += value;
        if (newHP > 5) {
            this.HP = 5;
        } else if (newHP < 0) {
            this.HP = 0;
        } else {
            this.HP = newHP;
        }
    }

    public int getPP() {
        return PP;
    }

    /* PP > 0 = ajouter des PP 
       PP < 0 = enlever des PP
    */
    public void addPP(int value) {
        int newPP = PP += value;
        if (newPP > 5) {
            this.PP = 5;
        } else if (newPP < 0) {
            this.PP = 0;
        } else {
            this.PP = newPP;
        }
    }
    
    public String getNom() {
        return nom;
    }

    public boolean applyStats(String stats, int value) {
        return switch (stats) {
            case "HP" -> {
                addHP(value);
                yield true;
            }
            case "PP" -> {
                addPP(value);
                yield true;
            }
            default -> false;
        };
    }
    
    public void supprimerCarteMain(Carte carte) {
        if (hands.contains(carte)) {
            hands.remove(carte);
            carte.appliqueEffet();
        } else {
            throw new IllegalArgumentException("Carte non trouvée dans la main du joueur\n");
        }
    }
    
    public void addCarte(Carte carte) {
        hands.add(carte);
    }

    @Override
    public String toString() {
        return "Pirate{" +
                "HP=" + HP +
                ", PP=" + PP +
                ", nom='" + nom + '\'' +
                '}';
    }
   
    public ArrayList<Carte> getMain() {
        return hands;
    }
    
    public Carte getCarteMain(String nomCarte) {
        for (Carte carte : hands) {
            if (carte.getNom().equals(nomCarte)) {
                return carte;
            }
        }
        
        System.out.println("Carte non trouvée dans la main du joueur\n");
        return null;
    }
    
    public int getNbCarte() {
        return hands.size();
    }
   
}
