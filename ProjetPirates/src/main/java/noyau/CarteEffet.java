package noyau;

/**
 *
 * @author yannf
 */

public abstract class CarteEffet extends Carte{
    protected CarteEffet(String nom, int carteID, String description, BasicCategorie zoneDepot) {
        super(nom, carteID, description, ExtendCategorie.EFFET, zoneDepot);
    }

}
