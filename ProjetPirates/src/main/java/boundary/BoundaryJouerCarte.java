package boundary;

import controleur.ControleurGetCarteInfo;
import controleur.ControleurJouerCarte;

import java.util.List;

public class BoundaryJouerCarte {
    private ControleurJouerCarte controleurJouerCarte; //final ?
    private ControleurGetCarteInfo controleurGetCarteInfo;  //final ?

    public BoundaryJouerCarte(ControleurJouerCarte controleurJouerCarte, ControleurGetCarteInfo controleurGetCarteInfo) {
        this.controleurJouerCarte = controleurJouerCarte;
        this.controleurGetCarteInfo = controleurGetCarteInfo;
    }

    public List<String> jouerCarte(String carte) {
        System.out.println("Le joueur joue la carte : " + carte);
        System.out.println("La carte a pour effet : " + controleurGetCarteInfo.getDescription(carte));
        List<String> res =  controleurJouerCarte.jouerCarte(carte);

        for (String s : res) {
            switch (s) {
                case "0" -> System.out.println("Résultat jet de piece est pile");
                case "1" -> System.out.println("Résultat jet de piece est face");
                case "Pas de gagnant" -> System.out.println("Pas de gagnant à la fin du tour, le tour passe au joueur suivant");
                case "Carte not trouvée" -> System.out.println("Erreur la carte joué n'existe pas dans la main du joueur");
                default -> System.out.println("le gagnant du jeu est : " + s);
            }
            System.out.println("---------------------------------------");
        }
        return  res;
    }
}
