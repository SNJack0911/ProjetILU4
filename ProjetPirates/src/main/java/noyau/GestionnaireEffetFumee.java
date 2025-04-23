/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyau;

import boundary.components.SmokeEffect;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author choue
 */

public class GestionnaireEffetFumee {

    private final List<Image> images = new ArrayList<>();

    public GestionnaireEffetFumee() {
        try {
            for (int i = 0; i <=3 ; i++) {
                Image img = ImageIO.read(new File("src/main/ressources/blackSmoke" + String.format("%02d", i) + ".png"));
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

private final List<SmokeEffect> fumeeList = new ArrayList<>();
/*
public void dessinerEffets(Graphics2D g2) {
    for (SmokeEffect f : fumeeList) {
        f.dessiner(g2);
    }

    // Nettoyage des fumées terminées
    fumeeList.removeIf(SmokeEffect::estTerminee);
}
*/
public void ajouterFumee(int x, int y) {
    Image img = getRandomImage();
    if (img != null) {
        SmokeEffect f = new SmokeEffect(img, x - 40, y - 40); // Décalage pour centrer sous la carte
        f.setSize(100); // ou 80, selon le rendu
        fumeeList.add(f);
    }
}


}
/*
public class GestionnaireEffetFumee {
    private final List<Image> images = new ArrayList<>();
    private final List<SmokeEffect> fumees = new ArrayList<>();

    public GestionnaireEffetFumee() {
        try {
            for (int i = 0; i <= 3; i++) {
                Image img = ImageIO.read(new File("src/main/ressources/blackSmoke" + String.format("%02d", i) + ".png"));
                images.add(img);
            }
        } catch (IOException e) {
            System.err.println("Erreur chargement fumée : " + e.getMessage());
        }
    }

    public void ajouterFumee(int x, int y) {
        Image img = getRandomImage();
        if (img != null) {
            SmokeEffect f = new SmokeEffect(img, x - 40, y - 40);
            f.setSize(100); // Plus gros effet
            fumees.add(f);
        }
    }

    public void dessinerEffets(Graphics2D g2) {
        Iterator<SmokeEffect> it = fumees.iterator();
        while (it.hasNext()) {
            SmokeEffect f = it.next();
            f.diminuerAlpha(0.05f);
            if (f.estTerminee()) {
                it.remove();
            } else {
                f.dessiner(g2);
            }
        }
    }

    public Image getRandomImage() {
        if (images.isEmpty()) return null;
        return images.get(new Random().nextInt(images.size()));
    }
}


*/