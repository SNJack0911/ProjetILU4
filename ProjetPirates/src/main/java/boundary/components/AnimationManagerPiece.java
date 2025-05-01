/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.components;

/**
 *
 * @author choue
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

import javax.swing.JPanel;


public class AnimationManagerPiece {

    private JPanel panelAnimation;
    private JLabel labelAnimation;

    public AnimationManagerPiece() {
        panelAnimation = new JPanel();
        panelAnimation.setPreferredSize(new Dimension(300, 300));
        panelAnimation.setBackground(Color.WHITE);
        labelAnimation = new JLabel();
        panelAnimation.add(labelAnimation);
    }

    public JPanel getPanelAnimation() {
        return panelAnimation;
    }

    public void afficherAnimation(String cheminGif) {
        ImageIcon icon = new ImageIcon(getClass().getResource(cheminGif));
        labelAnimation.setIcon(icon);
        labelAnimation.repaint();
    }

    /**
     * Gère uniquement les animations liées au jet de pièce pour la carte "Dans ta face"
     * La liste contient des strings : "0" (pile), "1" (face), autres valeurs ignorées ici
     */
    public void traiterAnimationLancerPiece(List<String> evenements) {
        for (String evenement : evenements) {
            if (evenement.equals("0")) {
                afficherAnimation("/resources/Animation-Lancer.gif");
                pause(1500);
                afficherAnimation("/resources/Animation-Noir.gif");
                pause(1500);
                break; // pile = fin effet
            } else if (evenement.equals("1")) {
                afficherAnimation("/resources/Animation-Lancer.gif");
                pause(1500);
                afficherAnimation("/resources/Animation-Jaune.gif");
                pause(1500);
            } else {
                // stop si on croise autre chose (comme nom de pirate, message final, etc.)
                //break;
            }
        }
    }

    private void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

