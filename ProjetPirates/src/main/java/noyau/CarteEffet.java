package noyau;

/**
 *
 * @author yannf
 */

public abstract class CarteEffet extends Carte{


    protected CarteEffet(String nom, int CarteID, String description, BasicCategorie zoneDepot) {
        super(nom, CarteID, description, ExtendCategorie.EFFET, zoneDepot);
    }

}
