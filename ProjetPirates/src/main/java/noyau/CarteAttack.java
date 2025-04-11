package noyau;

import java.util.List;

public class CarteAttack extends Carte{

    public CarteAttack(String nom, String description, List<Effet> effet) {
        super(nom, description, effet);
    }

    @Override
    public IEffet getEffet() {
        return null;
    }
}
