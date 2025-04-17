package noyau;

public enum ExtendCategorie implements ICategorieCarte {
    EFFET("Effet"), DEFENSE("Defense");

    private final String type;
    ExtendCategorie(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
