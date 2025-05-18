package noyau;

import java.util.*;

/**
 *
 * @author yannf, vincent et duc hai
 */


public class Pirate {
    private int hP;
    private int pP;
    private final String nom;
    private final ArrayList<Carte> hands = new ArrayList<>() ;
    public Pirate(String nom) {
        this.hP = 5;
        this.pP = 0;
        this.nom = nom;
    }

    public int getHP() {
        return hP;
    }

    /* HP > 0 = ajouter des HP 
       HP < 0 = enlever des HP */
    public void addHP(int value) {
        int newHP = hP + value;
        if (newHP > 5) {
            this.hP = 5;
        } else this.hP = Math.max(newHP, 0);
    }

    public int getPP() {
        return pP;
    }

    /* PP > 0 = ajouter des PP 
       PP < 0 = enlever des PP */
    public void addPP(int value) {
        int newPP = pP + value;
        if (newPP > 5) {
            this.pP = 5;
        } else this.pP = Math.max(newPP, 0);
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
            case "HP" -> this.hP = newStat;
            case "PP" -> this.pP = newStat;
            default -> throw new IllegalArgumentException("Stat non reconnue\n");
        }
    }
    
    public void supprimerCarteMain(Carte carte) {
        if (hands.contains(carte)) {
            hands.remove(carte);
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
                "HP=" + hP +
                ", PP=" + pP +
                ", nom='" + nom + '\'' +
                '}';
    }

    public List<Carte> getMain() {
        return hands;
    }
    
    public Carte getCarteMain(String nomCarte) {
        for (Carte carte : hands) {
            if (carte.getNom().equals(nomCarte)) {
                return carte;
            }
        }
        
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
    
    @Override
    public int hashCode() {
    	return nom != null ? nom.hashCode() : 0;
    }
    
}
