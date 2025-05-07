package noyau;
/**
 *
 * @author yann
 */
public class EffetEtatJeu {
    private int tourRestant;

    private final double multiplieurHPPirate1;
    private final double multiplieurHPPirate2;
    private final double multiplieurPPPirate1;
    private final double multiplieurPPPirate2;

    private final TypeChangement typeChangement;

    private final int[] gameState = new int[4];


    public EffetEtatJeu(int duree, double multiplieurHPPirate1, double multiplieurHPPirate2,
                        double multiplieurPPPirate1, double multiplieurPPPirate2, TypeChangement typeChangement){
        tourRestant = duree;
        this.multiplieurHPPirate1 = multiplieurHPPirate1;
        this.multiplieurHPPirate2 = multiplieurHPPirate2;
        this.multiplieurPPPirate1 = multiplieurPPPirate1;
        this.multiplieurPPPirate2 = multiplieurPPPirate2;
        this.typeChangement = typeChangement;

    }

    public boolean hasTourRestant(){
        return tourRestant>0;
    }

    public void debutTour(Pirate pirate1, Pirate pirate2){
        gameState[0] = pirate1.getPP();
        gameState[1] = pirate1.getHP();
        gameState[2] = pirate2.getPP();
        gameState[3] = pirate2.getHP();
    }

    public void finTour(Pirate pirate1, Pirate pirate2){
        double newHPPirate1 = pirate1.getHP() - gameState[1];
        double newPPPirate1 = pirate1.getPP() - gameState[0];
        double newPPPirate2 = pirate2.getPP() - gameState[2];
        double newHPPirate2 = pirate2.getHP() - gameState[3];

        if (typeChangement.equals(TypeChangement.DIMINUTION)){
            newPPPirate1 = newPPPirate1<0 ? newPPPirate1 * multiplieurPPPirate1 : newPPPirate1;
            newHPPirate1 = newHPPirate1<0 ? newHPPirate1 * multiplieurHPPirate1 : newHPPirate1;
            newPPPirate2 = newPPPirate2<0 ? newPPPirate2 * multiplieurPPPirate2 : newPPPirate2;
            newHPPirate2 = newHPPirate2<0 ? newHPPirate2 * multiplieurHPPirate2 : newHPPirate2;
        } else if (typeChangement.equals(TypeChangement.AUGMENTATION)) {
            newPPPirate1 = newPPPirate1>0 ? newPPPirate1 * multiplieurPPPirate1 : newPPPirate1;
            newHPPirate1 = newHPPirate1>0 ? newHPPirate1 * multiplieurHPPirate1 : newHPPirate1;
            newPPPirate2 = newPPPirate2>0 ? newPPPirate2 * multiplieurPPPirate2 : newPPPirate2;
            newHPPirate2 = newHPPirate2>0 ? newHPPirate2 * multiplieurHPPirate2 : newHPPirate2;
        } else {
            newPPPirate1 = newPPPirate1 * multiplieurPPPirate1;
            newHPPirate1 = newHPPirate1 * multiplieurHPPirate1;
            newPPPirate2 = newPPPirate2 * multiplieurPPPirate2;
            newHPPirate2 = newHPPirate2 * multiplieurHPPirate2;
        }
        pirate1.setStats("PP", (int) (gameState[0] + newPPPirate1));
        pirate1.setStats("HP", (int) (gameState[1] + newHPPirate1));
        pirate2.setStats("PP", (int) (gameState[2] + newPPPirate2));
        pirate2.setStats("HP", (int) (gameState[3] + newHPPirate2));

        updateTourRestant();
    }

    protected int getGameState(int index){
        return gameState[index];
    }

    protected void updateTourRestant(){
        tourRestant--;
    }
}
