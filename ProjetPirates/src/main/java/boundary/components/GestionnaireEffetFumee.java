/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.components;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author leo
 */

public class GestionnaireEffetFumee {

    private final List<Image> images = new ArrayList<>();
    private final List<SmokeEffect> fumeeList;

    public GestionnaireEffetFumee() {
        this.fumeeList = new ArrayList<>(); // pour "ajouterFumee"
        try {
            for (int i = 0; i <=3 ; i++) {
                Image img = ImageIO.read(new File("src/main/resources/blackSmoke" + String.format("%02d", i) + ".png"));
                images.add(img);
            }
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Erreur chargement fumées : " + e.getMessage());
        }
    }

    public Image getRandomImage() {
        if (images.isEmpty()) return null;
        return images.get(new Random().nextInt(images.size()));
    }  

    public void ajouterFumee(int x, int y) {
        Image img = getRandomImage();
        if (img != null) {
            SmokeEffect f = new SmokeEffect(img, x - 40, y - 40); // Décalage pour centrer sous la carte
            f.setSize(100); // ou 80, selon le rendu
            fumeeList.add(f);
        }
    }

}
