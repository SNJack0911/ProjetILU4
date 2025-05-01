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


public class AnimationManagerPieceCreux {

    private JPanel panelAnimation;
    private JLabel labelAnimation;

    public AnimationManagerPieceCreux() {
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
    private void afficherLancerEtResultat(String animationResultat, int delayLancer, int delayResultat) {
        afficherAnimation("/resources/Animation-Lancer.gif");
        pause(delayLancer);
        afficherAnimation(animationResultat);
        pause(delayResultat);
    }

    public void traiterAnimationLancerPiece(List<String> evenements) {
        for (String evenement : evenements) {
            switch (evenement) {
                case "0" -> {
                    afficherLancerEtResultat("/resources/Animation-Noir.gif", 2500, 1500);
                    break;
                }
                case "1" -> afficherLancerEtResultat("/resources/Animation-Jaune.gif", 2500, 1500);
                default -> {
                    // stop si on croise autre chose (comme nom de pirate, message final, etc.)
                //break;
                }
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

