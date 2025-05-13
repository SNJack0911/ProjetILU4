package noyau;

/**
 *
 * @author yannf
 */

public class CarteDefense extends  Carte{
    private int PVajout;
    private int PPajout;
    private boolean affecterNuit;

    public CarteDefense(String nom, int carteID, String description, int PVajout, int PPajout, boolean affecterNuit) {
        super(nom, carteID, description, ExtendCategorie.DEFENSE, BasicCategorie.POPULARITE);
        this.PVajout = PVajout;
        this.PPajout = PPajout;
        this.affecterNuit = affecterNuit;
    }

    @Override
    public void appliquerEffet(Pirate joueur, Pirate adversaire, Jeu jeu) {
        if(affecterNuit && !jeu.isNuit()){
            PVajout += PVajout;
        }
        joueur.applyStats("HP", PVajout);
        joueur.applyStats("PP", PPajout);
    }
}