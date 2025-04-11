package com.ilu4.jeuxpirate.noyau;

public abstract class Carte implements ICarte {
    private String nom;
    private String description;
    private IEffet[] effets;

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
