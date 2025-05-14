package noyau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import reference.*;
/*
* Stefan
* */

class CarteTest {

    @Test
    void testAttackEffet() {
        CarteAttack carte = new CarteAttack("Attaque Test", 0, "Desc", 3, 6, -2, -4, false, false);

        Jeu jeu = new Jeu();
        jeu.setNuit(false);
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");

        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(5, joueur.getHP(), "HP joueur incorrect");
        assertEquals(3, joueur.getPP(), "PP joueur incorrect");
        assertEquals(0, adversaire.getPP(), "PP adversaire incorrect");
        assertEquals(1, adversaire.getHP(), "HP adversaire incorrect");

        System.out.println("✔ attackEffet");
    }

    @Test
    void testDefenseEffet() {
        CarteDefense carte = new CarteDefense("Bouclier", 0,"def", 1, 2, true);

        Jeu jeu = new Jeu();
        jeu.setNuit(false);
        Pirate joueur = new Pirate("Tom");
        Pirate adversaire = new Pirate("Jerry");
        joueur.addHP(-2);
        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(5, joueur.getHP(), "HP doublé car pas la nuit");
        assertEquals(2, joueur.getPP(), "PP joueur incorrect");
        System.out.println("✔ defenseEffet");
    }

}