/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyau;

import java.util.List;

/**
 *
 * @author hai
 */
public class CarteEffet extends Carte implements ICarte {

    protected CarteEffet(String nom, String description, ICategorieCarte categorie, BasicCategorie zoneDepot) {
        super(nom, description, categorie, zoneDepot);
    }

    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        return List.of();
    }
}
