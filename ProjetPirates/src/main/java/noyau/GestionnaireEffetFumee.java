/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noyau;

import boundary.components.SmokeEffect;
import java.awt.Graphics2D;
import java.awt.Image;
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

    private List<SmokeEffect> effets = new ArrayList<>();
    private Timer timer;
    private final Image[] images;

    public GestionnaireEffetFumee(JPanel panel) {
        // Charge les images
        images = new Image[10];
        for (int i = 0; i < images.length; i++) {
            try {
                images[i] = ImageIO.read(getClass().getResource("/les_pngBlackSmoke/blackSmoke" + String.format("%02d", i) + ".png"));
            } catch (IOException e) {
                System.err.println("Erreur chargement image fumée : " + i);
            }
        }

        // Lance le timer pour nettoyer les smokes
        timer = new Timer(100, e -> {
            effets.removeIf(SmokeEffect::isExpired);
            panel.repaint(); // Pour que le plateau se redessine avec ou sans smokes
        });
        timer.start();
    }

    public void ajouterFumee(int x, int y) {
        int index = new Random().nextInt(images.length);
        effets.add(new SmokeEffect(images[index], x, y));
    }

    public void dessinerEffets(Graphics2D g) {
        for (SmokeEffect effet : effets) {
            g.drawImage(effet.image, effet.x, effet.y, null);
        }
    }
}
