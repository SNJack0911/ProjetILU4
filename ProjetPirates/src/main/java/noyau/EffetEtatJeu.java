package noyau;


/**
 *
 * @author yann et fanny
 */
public class EffetEtatJeu {
    private int tourRestant;
    
    //{HPPirate1, HPPirate2, PP Pirate1, PPPirate2
    private double[] multiplieur = new double[4];
   

    private final TypeChangement typeChangement;

    private final int[] gameState = new int[4];


    public EffetEtatJeu(Pirate pirate1, Pirate pirate2, int duree, double[] multiplieur, TypeChangement typeChangement){
        tourRestant = duree;
        this.multiplieur = multiplieur;
        this.typeChangement = typeChangement;

        debutTour(pirate1, pirate2);

    }

    public boolean hasTourRestant(){
        return tourRestant>0;
    }

    public void debutTour(Pirate pirate1, Pirate pirate2){
        gameState[0] = pirate1.getHP();
        gameState[1] = pirate2.getHP();
        gameState[2] = pirate1.getPP();
        gameState[3] = pirate2.getPP();
        
    }

    public void finTour(Pirate pirate1, Pirate pirate2){
    
    	double[] newStats = {
    	        pirate1.getHP() - gameState[0],
    	        pirate2.getHP() - gameState[1],
    	        pirate1.getPP() - gameState[2],
    	        pirate2.getPP() - gameState[3]
    	        
    	};
    	
    	for(int i=0; i<4; i++) {
    		newStats[i] = ajusterStat(newStats[i], multiplieur[i]);
    	}
    	
        pirate1.setStats("HP", (int) (gameState[0] + newStats[0]));
        pirate2.setStats("HP", (int) (gameState[1] + newStats[1]));
        pirate1.setStats("PP", (int) (gameState[2] + newStats[2]));
        pirate2.setStats("PP", (int) (gameState[3] + newStats[3]));

        updateTourRestant();
    }
    
    private double ajusterStat(double stat, double multiplieur) {
    	switch (typeChangement) {
			case DIMINUTION: {
				return stat < 0 ? stat * multiplieur : stat;
			}
			case AUGMENTATION:{
				return stat >0? stat * multiplieur : stat;
			}
			default:
				return stat * multiplieur;
		}
    	
    }

    protected int getGameState(int index){
        return gameState[index];
    }

    protected void updateTourRestant(){
        tourRestant--;
    }
}
