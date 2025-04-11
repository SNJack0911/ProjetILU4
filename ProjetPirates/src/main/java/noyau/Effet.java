package noyau;

import java.util.Map;

public class Effet implements IEffet {

    private Pirate player;
    private Map<String, Integer> effet;

    public Effet (Pirate player, Map<String, Integer> effet){
        this.player = player;
        this.effet = effet;
    }
    
    @Override
    public void appliqueEffet() {
        for (String stat : effet.keySet()) {
            if (player.applyStats(stat, effet.get(stat))){
                System.out.println("Effet appliqué : " + stat + " " + effet.get(stat));
            }else{
                throw new IllegalArgumentException("Statistique non reconnue : " + stat);
            }
        }
    }
}
