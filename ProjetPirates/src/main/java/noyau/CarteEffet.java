/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 *
 * @author hai
 */
public class CarteEffet extends Carte {
    private EffectName effectname;

    protected CarteEffet(String nom, int carteID, String description, ICategorieCarte categorie, BasicCategorie zoneDepot,EffectName effectname) {
        super(nom, carteID, description, categorie, zoneDepot);
        this.effectname = effectname;
    }
    private List<String> toucher_d_encre(Pirate joueur,Pirate adversaire,Jeu jeu){
        List<Carte> possible = adversaire.getMain();
        Random rand = new Random();
        int randomIndex = rand.nextInt(possible.size());
        adversaire.supprimerCarteMain(possible.get(randomIndex));
        return new ArrayList<String>();
    }
    private List<String> sourd_d_oreille(Pirate joueur,Pirate adversaire,Jeu jeu){
        int PPjoueur = joueur.getPP();
        int PVjoueur = joueur.getHP();
        int PPadver = adversaire.getPP();
        int PVadver = adversaire.getHP();
        return null;
    }
    @Override
    public List<String> appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        return switch (effectname) {
            case TOUCHE_D_ENCRE -> toucher_d_encre(joueur, adversaire,jeu);
            case SOURD_D_OREILLE -> sourd_d_oreille(joueur, adversaire,jeu);
//            case JACKO_LE_FOUINEUR -> jacko_le_fouineu(joueur, adversaire,jeu);
//            case EFFET_AMPLIFICATEUR -> effet_amplificateur(joueur, adversaire,jeu);
//            case DENIE -> denie(joueur, adversaire,jeu);
//            case CARTE_PIEGE_YUGI -> carte_piege_yugi(joueur, adversaire,jeu);
            default -> null;
        };
    }
    
}
