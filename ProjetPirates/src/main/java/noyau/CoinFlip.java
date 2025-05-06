package noyau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoinFlip {
    private static final Random rand = new Random();
    List<String> listeFace = new ArrayList<>();

    public int flipCoins(){
        int face;
        int compteur = -2;
        do{
            face = rand.nextInt(2);
            compteur+=1;
            listeFace.add(face + "");
        }while (face != 1 && compteur <= 3);
        return compteur;
    }

    public List<String> getFace(){
        return listeFace;
    }
}
