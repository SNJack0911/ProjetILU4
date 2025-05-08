package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author yannf
 */

public class Jeu {
    private final Pirate joueur1;
    private final Pirate joueur2;
    private final JeuDeCarte jeuDeCarte;
    private Pioche pioche;
    private int tour;
    private boolean nuit=false;
    private final ArrayList<EffetEtatJeu> effetsJeu = new ArrayList<>();

    public Jeu(){
        joueur1 = new Pirate("Jake Gibbs");
        joueur2 = new Pirate("Tobias Blackbeard");
        jeuDeCarte = new JeuDeCarte();
        pioche = new Pioche(jeuDeCarte.remplirPioche());
        tour = 0;
        for(int i =0; i<4; i++){
            joueur1.addCarte(pioche.piocher());
            joueur2.addCarte(pioche.piocher());
        }
    }

    protected boolean isJeuTermine(){
        return joueur1.getPP() == 5 || joueur2.getPP() == 5 ||
               joueur1.getHP() == 0 || joueur2.getHP() == 0;
    }

    protected String getGagnant(){
        if (joueur1.getPP() >= 5 || joueur2.getHP() <= 0){
            return joueur1.getNom();
        } else if (joueur2.getPP() >= 5 || joueur1.getHP() <= 0){
            return joueur2.getNom();
        }
        return "Pas de gagnant";
    }

    public ArrayList<Carte> jouerPioche() {
        return piocherInf5(getJoueurActuel());
    }

    //Renvoyer un joueur si les cartes ne sont pas ajouté à la main du joueur
    private ArrayList<Carte> piocherInf5(Pirate joueur){
        Carte carte;
        ArrayList<Carte> cartesLst = new ArrayList<>();
        while (joueur.getNbCarte()<5){
            if (pioche.estVide()){
                pioche = new Pioche(jeuDeCarte.remplirPioche());
            }
            try {
                carte = pioche.piocher();
            } catch (IllegalStateException e) {
                System.err.println("Erreur piocher carte : " + e.getMessage());
                return cartesLst;
            }
            joueur.addCarte(carte);
            cartesLst.add(carte);
        }
        return cartesLst;
    }

    public Pirate getJoueurActuel() {
        return (tour % 2 == 0) ? joueur1 : joueur2;
    }

    public Pirate getAdversaireActuel() {
        return (tour % 2 == 0) ? joueur2 : joueur1;
    }

    public void incrementerTour() {

        tour++;
    }
    
    //Update String return
    public List<String> jouerTour(String nomCarte) {
        Pirate joueur = getJoueurActuel();
        Pirate adversaire = getAdversaireActuel();
        Carte carte = joueur.getCarteMain(nomCarte);

        if (carte == null) {
            return List.of("Carte pas trouvée");
        }

        List<String> resultatTour = jouerCarte(carte, joueur, adversaire);

        joueur.supprimerCarteMain(carte);

        resultatTour.add(getGagnant());
        return resultatTour;
    }

    protected List<String> jouerCarte(Carte carte, Pirate joueur, Pirate adversaire) {
        // Appliquer les effets de début de tour
        for(EffetEtatJeu effet : effetsJeu){
            effet.debutTour(joueur, adversaire);
        }

        // Appliquer l'effet de la carte
        carte.appliquerEffet(joueur, adversaire, this);

        // Créer une liste temporaire pour stocker les effets à supprimer
        ArrayList<EffetEtatJeu> effetsASupprimer = new ArrayList<>();
        
        // Vérifier les effets de fin de tour
        for(EffetEtatJeu effet : effetsJeu){
            effet.finTour(joueur, adversaire);
            if (!effet.hasTourRestant()) {
                effetsASupprimer.add(effet);
            }
        }
        
        // Supprimer les effets terminés après l'itération
        for(EffetEtatJeu effet : effetsASupprimer) {
            supprimerEffetJeu(effet);
        }
        
        return genResultat(carte);
    }

    private List<String> genResultat(Carte carte) {
        List<String> resultatTour = new ArrayList<>();
        if (carte instanceof CartePiecePopularite cartePiece) {
            resultatTour = cartePiece.getCoinFlipResult();
        } else if (carte instanceof CartePieceAttaque cartePiece) {
            resultatTour = cartePiece.getCoinFlipResult();
        }/* else if (carte instanceof CarteEffet carteEffet) { //TODO traiter dans l'IHM les cartes effets
            resultatTour.add(carteEffet.getNom());
        }*/
        return resultatTour;
    }

    public boolean isNuit() {
        return nuit;
    }

    public void setNuit(Boolean isNuit) {
        nuit = Objects.requireNonNullElseGet(isNuit, () -> tour % 4 == 2 || tour % 4 == 3);
    }
    

    public JeuDeCarte getJeuDeCarte() {
        return jeuDeCarte;
    }

    public Pirate getPirate(int numero) {
        return switch (numero) {
            case 0 -> joueur1;
            case 1 -> joueur2;
            default -> null;
        };
    }

    public int getTour() {
        return tour;
    }

    public void ajouterEffetJeu(EffetEtatJeu effet){
        effetsJeu.add(effet);
    }

    public void supprimerEffetJeu(EffetEtatJeu effet){
        effetsJeu.remove(effet);
    }

}