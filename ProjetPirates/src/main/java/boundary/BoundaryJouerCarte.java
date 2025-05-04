package boundary;

import boundary.components.JCarte;
import controleur.ControleurGetCarteInfo;
import controleur.ControleurJouerCarte;

import java.util.List;

public class BoundaryJouerCarte {
    private ControleurJouerCarte controleurJouerCarte;
    private ControleurGetCarteInfo controleurGetCarteInfo;

    public BoundaryJouerCarte(ControleurJouerCarte controleurJouerCarte, ControleurGetCarteInfo controleurGetCarteInfo) {
        this.controleurJouerCarte = controleurJouerCarte;
        this.controleurGetCarteInfo = controleurGetCarteInfo;
    }


    public List<String> jouerCarte(String carte) {
        System.out.println("Le joueur joue la carte : " + carte);
        System.out.println("La carte a pour effet : " + controleurGetCarteInfo.getDescription(carte));
        List<String> res =  controleurJouerCarte.jouerCarte(carte);

        for (String s : res) {
            if (s.equals("0")) {
                System.out.println("Résultat jet de piece est pile");
            } else if (s.equals("1")) {
                System.out.println("Résultat jet de piece est face");
            } else if (s.equals("Pas de gagnant")) {
                System.out.println("Pas de gagnant à la fin du tour, le tour passe au joueur suivant");
            } else if (s.equals("Carte not trouvée")) {
                System.out.println("Erreur la carte joué n'existe pas dans la main du joueur");
            } else {
                System.out.println("le gagnant du jeu est : " + s);
            }
            System.out.println("---------------------------------------");
        }
        return  res;
        //Les evenements sont de la forme : ["0", "0", "1", "Pas de Gagnant"] //0 = pile et 1 = face
        //                                  ["1", "NomPirate1"]
        //                                  ["NomPirate2"]

    }
}
