package noyau;

import java.util.*;

/**
 *
 * @author ..., yannf, vincent et duc hai
 */


public class Pirate {
    private int HP;
    private int PP;
    private final String nom;
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
        int newHP = HP + value;
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
        int newPP = PP + value;
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
    
    public void setStats(String stat, int value) {
        int newStat = value>5?5: Math.max(value, 0);
        switch (stat) {
            case "HP" -> {
                this.HP = newStat;
            }
            case "PP" -> {
                this.PP = newStat;
            }
            default -> {
                throw new IllegalArgumentException("Stat non reconnue\n");
            }
        }
    }
    
    public void supprimerCarteMain(Carte carte) {
        if (hands.contains(carte)) {
            hands.remove(carte);
            //carte.appliqueEffets();
        } else {
            throw new IllegalArgumentException("Carte non trouvée dans la main du joueur\n");
        }
    }
    
    public void addCarte(Carte carte) {
        hands.add(carte);
        //System.out.println("Carte ajouter dans la main du joueur : " + carte.getNom() + "\n");
    }

    @Override
    public String toString() {
        return "Pirate{" +
                "HP=" + HP +
                ", PP=" + PP +
                ", nom='" + nom + '\'' +
                '}';
    }

    //Useless now
    public ArrayList<Carte> getMain() {
        return hands;
    }
    
    public Carte getCarteMain(String nomCarte) {
        for (Carte carte : hands) {
            if (carte.getNom().equals(nomCarte)) {
                return carte;
            }
        }
        
        //System.out.println("Carte non trouvée dans la main du joueur\n");
        return null;
    }
    
    public int getNbCarte() {
        return hands.size();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pirate pirate) {
            return nom.equals(pirate.getNom());
        }
        return false;
    }
}
