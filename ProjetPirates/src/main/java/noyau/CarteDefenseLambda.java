package noyau;

/**
 *
 * @author yannf
 */

public class CarteDefenseLambda extends CartePopulariteLambda {

    public CarteDefenseLambda(String nom, int carteID, String description, IEffet effetHPJ) {
        super(nom, carteID, description, ExtendCategorie.DEFENSE, null, effetHPJ);
    }
}
