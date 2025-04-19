package noyau;

public enum BasicCategorie implements ICategorieCarte {
    POPULARITE("Popularite"), ATTAQUE("Attaque");

    private final String type;
    BasicCategorie(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }
}
