package noyau;

import noyau.carteeffet.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yannf
 */
class CarteEffetTest {
    private Jeu jeu;
    private Pirate joueur;
    private Pirate adversaire;

    @BeforeEach
    void setUp() {
        jeu = new Jeu();
        joueur = new Pirate("Tom");
        adversaire = new Pirate("Jerry");
    }

    @Test
    void carteAntidouleurAdversaireTest(){
        CarteAntidouleur carte1 = new CarteAntidouleur();
        joueur.addHP(-1);
        carte1.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(5, joueur.getHP(), "Ajout des HP est incorrect");

        CarteAttaqueLambda carte2 = new CarteAttaqueLambda("Carte", -1, "desc",
                null, ((pirate, jeu1) -> pirate.getHP()-1));

        jeu.jouerCarte(carte2, adversaire, joueur);

        assertEquals(5, joueur.getHP(), "Protection contre les attaques incorrect");


        jeu.jouerCarte(carte2, adversaire, joueur);

        assertEquals(4, joueur.getHP(), "Durée de la protection contre les attaques incorrect");
    }

    @Test
    void carteAntidouleurJoueurTest(){
        CarteAntidouleur carte1 = new CarteAntidouleur();
        adversaire.addPP(-1);
        carte1.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(5, adversaire.getHP(), "Ajout des HP est incorrect");

        CartePopulariteLambda carte2 = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                null, ((pirate, game) -> pirate.getHP() - 1));
        jeu.jouerCarte(carte2, joueur, adversaire);

        assertEquals(5, joueur.getHP(), "Protection contre les attaques incorrect");


        jeu.jouerCarte(carte2, joueur, adversaire);

        assertEquals(4, joueur.getHP(), "Durée de la protection contre les attaques incorrect");
    }

    @Test
    void CarteEffetAmplificateurTest(){
        CarteEffetAmplificateur carte1 = new CarteEffetAmplificateur();
        carte1.appliquerEffet(joueur, adversaire, jeu);

        CartePopulariteLambda carte2 = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                null, ((pirate, game) -> pirate.getHP() - 1));
        jeu.jouerCarte(carte2, joueur, adversaire);

        assertEquals(4, joueur.getHP(), "Suppression des HP est incorrect");

        CartePopulariteLambda carte3 = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                ((pirate, game) -> pirate.getPP() + 1), null);

        jeu.jouerCarte(carte3, joueur, adversaire);

        assertEquals(2, joueur.getPP(), "Ajout des PP n'as pas était doublé");
    }

    @Test
    void CartePiedMarinTest(){
        CartePiedMarin carte1 = new CartePiedMarin();
        carte1.appliquerEffet(joueur, adversaire, jeu);

        CartePopulariteLambda carte2 = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                ((pirate, game) -> pirate.getPP() + 2), null);
        jeu.jouerCarte(carte2, adversaire, joueur);
        assertEquals(2, adversaire.getPP(), "L'ajout des PP de l'adversaire est incorrect");


        CarteAttaqueLambda carte3 = new CarteAttaqueLambda("Carte", -1, "desc",
                null, ((pirate, game) -> pirate.getHP() - 2));
        jeu.jouerCarte(carte3, joueur, adversaire);
        assertEquals(4, adversaire.getHP(), "La suppression des HP de l'adversaire n'est pas bien diviser par deux");
    }

    @Test
    void CarteSourdOreilleDiminutionTest(){
        CarteSourdOreille carte1 = new CarteSourdOreille();
        carte1.appliquerEffet(joueur, adversaire, jeu);

        CartePopulariteLambda carte2 = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                null, ((pirate, game) -> pirate.getHP() - 2));
        jeu.jouerCarte(carte2, joueur, adversaire);
        assertEquals(5, joueur.getHP(), "La carte popularité ne doit pas avoir d'effet");
    }

    @Test
    void CarteSourdOreilleAugmentationTest(){
        CarteSourdOreille carte1 = new CarteSourdOreille();
        carte1.appliquerEffet(joueur, adversaire, jeu);

        CartePopulariteLambda carte2 = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                ((pirate, game) -> pirate.getPP() + 2), null);
        jeu.jouerCarte(carte2, joueur, adversaire);
        assertEquals(2, joueur.getPP(), "La carte effet ne doit pas avoir d'effet");
    }

    @Test
    void CarteToucheEncreTest(){
        CarteToucheEncre carte1 = new CarteToucheEncre();
        adversaire.addCarte(new CarteAntidouleur());
        adversaire.addCarte(new CartePiedMarin());
        int nbCarteAdversaire = adversaire.getNbCarte();

        carte1.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(nbCarteAdversaire-1, adversaire.getNbCarte(), "La taille de la main de l'adversaire n'est pas correcte");

    }

    @Test
    void CarteToucheEncreMainVideTest(){
        CarteToucheEncre carte1 = new CarteToucheEncre();
        int nbCarteAdversaire = adversaire.getNbCarte();
        assertEquals(0, nbCarteAdversaire, "La main du joueur n'est pas vide");

        carte1.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(0, adversaire.getNbCarte(), "La taille de la main de l'adversaire a changé");

    }
}