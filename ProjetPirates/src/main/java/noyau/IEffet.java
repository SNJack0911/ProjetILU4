package noyau;

@FunctionalInterface
public interface IEffet {
    //Could be a pre-existing functional interface if we delete jeu
    int newValue(Pirate pirate, Jeu jeu);

}
