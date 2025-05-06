package noyau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarteLambdaTest {

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
    void cartePopulariteLambda() {
        CartePopulariteLambda carte = new CartePopulariteLambda("Carte", -1, "desc", BasicCategorie.POPULARITE,
                ((pirate, jeu) -> pirate.getPP() +1), ((pirate, jeu) -> pirate.getHP() - 1));
        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(1, joueur.getPP(), "PP joueur incorrect");
        assertEquals(4, joueur.getHP(), "HP joueur incorrect");
        System.out.println("✔ CartePopulariteLambda");
    }

    @Test
    void carteNuitPopularite(){
        joueur.addHP(-3);
        assertEquals(2, joueur.getHP(), "HP joueur incorrect pour le test");
        CarteNuitPopularite carte = new CarteNuitPopularite("Carte", -1, "desc", BasicCategorie.POPULARITE,
                null, ((pirate, jeu) -> pirate.getHP() + 1));
        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(4, joueur.getHP(), "HP joueur incorrect après tour jour");
        jeu.setNuit(true);
        carte.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(5, joueur.getHP(), "HP joueur incorrect après tour nuit");

        System.out.println("✔ CarteNuitPopularite");
    }

    @Test
    void cartePiecePolularite(){
        CartePiecePopularite carte = new CartePiecePopularite("Carte", -1, "desc", BasicCategorie.POPULARITE,
                ((pirate, jeu) -> pirate.getPP() +1), null);
        carte.appliquerEffet(joueur, adversaire, jeu);

        List<String> res = carte.getCoinFlipResult();

        assertEquals(res.size()-1, joueur.getPP(),"Valeurs different entre nombre de pile et nombre PP gagné");
        System.out.println("✔ CartePiecePopularite");
    }

    @Test
    void carteDefenseLambda(){
        joueur.addHP(-2);
        CarteDefenseLambda carte = new CarteDefenseLambda("Carte", -1, "desc",((pirate, jeu) -> pirate.getHP()+1));

        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(4, joueur.getHP(),"HP joueur incorrect");
        System.out.println("✔ CarteDefenseLambda");
    }

    @Test
    void carteAttaqueLambda(){
        joueur.addPP(-2);
        CarteAttaqueLambda carte = new CarteAttaqueLambda("Carte", -1, "desc",
                ((pirate, jeu1) -> pirate.getHP()+2), ((pirate, jeu1) -> pirate.getHP()-1));
        carte.appliquerEffet(joueur, adversaire, jeu);

        assertEquals(5, joueur.getHP(),"HP joueur incorrect");
        assertEquals(4, adversaire.getHP(),"HP adversaire incorrect");
        System.out.println("✔ CarteAttaqueLambda");
    }

    @Test
    void carteNuitAttaque(){
        CarteNuitAttaque carte = new CarteNuitAttaque("Carte", -1, "desc",
                null, ((pirate, jeu) -> pirate.getHP()-1));
        /*Carte Equivalent
        CarteAttaqueLambda carte2 = new CarteAttaqueLambda("Carte", -1, "desc",
                null, ((pirate, jeu) -> {
                    if (jeu.isNuit()) return pirate.getHP()-2;
                    return pirate.getHP()-1;
                    }));
        */
        carte.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(4, adversaire.getHP(),"HP adversaire incorrect pendant le tour jour");

        jeu.setNuit(true);


        carte.appliquerEffet(joueur, adversaire, jeu);
        assertEquals(2, adversaire.getHP(),"HP adversaire incorrect pendant le tour nuit");
        System.out.println("✔ CarteNuitAttaque");
    }

    @Test
    void cartePieceAttaque(){
        int hpAdversaireInit = adversaire.getHP();
        CartePieceAttaque carte = new CartePieceAttaque("Carte", -1, "desc",
                null, ((pirate, jeu) -> pirate.getHP()-1));

        carte.appliquerEffet(joueur, adversaire, jeu);

        List<String> res = carte.getCoinFlipResult();

        assertEquals(res.size()-1, hpAdversaireInit - adversaire.getHP(),
                "Valeurs different entre nombre de pile et nombre HP perdu par l'adversaire");
        System.out.println("✔ CartePieceAttaque");
    }

}