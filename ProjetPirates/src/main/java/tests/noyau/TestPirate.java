package tests.noyau;

import noyau.*;

public class TestPirate {

    public static void main(String[] args) {
        testInit();
        testHP();
        testPP();
        testAddCarte();
        testGetCarteMain();
        testSupprimerCarteMain();
        testGetNbCarte();
    }

    public static void testInit() {
        Pirate p = new Pirate("Pierre");
        System.out.println("HP:" + p.getHP());
        System.out.println("PP:" + p.getPP());
        System.out.println("Nom:" + p.getNom());
        System.out.println("Init test passed");
    }

    public static void testHP() {
        Pirate p = new Pirate("P1");
        p.applyStats("HP", -3);//2
        assert p.getHP() == 2 : "Expected HP = 2, Got: " + p.getHP();
        p.applyStats("HP", 10); //5
        assert p.getHP() == 5 : "Expected HP = 5, Got: " + p.getHP();
        p.applyStats("HP", -10); //0
        assert p.getHP() == 0 : "Expected HP = 0, Got: " + p.getHP();
        System.out.println("testHP passed");
    }

    public static void testPP() {
        Pirate p = new Pirate("PPTester");
        p.applyStats("PP", 4);
        assert p.getPP() == 4 : "Expected PP = 4, Got: " + p.getPP();
        p.applyStats("PP", 10);
        assert p.getPP() == 5 : "Expected PP = 5, Got: " + p.getPP();
        p.applyStats("PP", -10);
        assert p.getPP() == 0 : "Expected PP = 0, Got: " + p.getPP();
        System.out.println("testPP passed");
    }

    public static void testAddCarte() {
        Pirate p = new Pirate("P2");
        Carte card = new CarteAttack("C1", 0, "Carte Attaque", 1, 0, 0, -1, false, false);
        p.addCarte(card);
        assert p.getMain().size() == 1 : "Expected size = 1, Got: " + p.getMain().size();
        System.out.println("testAddCarte passed");
    }

    public static void testGetCarteMain() {
        Pirate p = new Pirate("P3");
        Carte card = new CartePopularite("Popular", 0, "Boost", 2, 1, false);
        p.addCarte(card);
        Carte found = p.getCarteMain("Popular");
        assert found != null : "Expected card not found";
        assert found.getNom().equals("Popular") : "Expected card name = Popular, Got: " + found.getNom();
        System.out.println("testGetCarteMain passed");
    }

    public static void testSupprimerCarteMain() {
        Pirate p = new Pirate("P4");
        Carte card = new CarteDefense("Defense",0,  "Blockage", 2, 0, false);
        p.addCarte(card);
        assert p.getMain().size() == 1 : "Expected size = 1, Got: " + p.getMain().size();
        p.supprimerCarteMain(card);
        assert p.getMain().size() == 0 : "Expected size = 0, Got: " + p.getMain().size();
        try {
            p.supprimerCarteMain(card);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected exception caught: " + e.getMessage().trim());
        }
        System.out.println("testSupprimerCarteMain passed");
    }

    public static void testGetNbCarte() {
        Pirate p = new Pirate("CountTester");
        p.addCarte(new CarteAttack("A", 0, "Attack", 1, 1, 0, -1, false, false));
        p.addCarte(new CarteDefense("D", 0, "Defense", 2, 0, false));
        assert p.getNbCarte() == 2 : "Expected count = 2, Got: " + p.getNbCarte();
        System.out.println("testGetNbCarte passed");
    }
}
