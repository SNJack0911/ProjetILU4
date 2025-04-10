package boundary.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author choue
 */


public class JCartePopUp extends JWindow {

    public JCartePopUp(JFrame parent, Image image) {
        super(parent);

        JLabel label = new JLabel(new ImageIcon(image));
        getContentPane().add(label);

        pack();
        setLocationRelativeTo(parent);
        setAlwaysOnTop(true); // reste au-dessus
        setVisible(true);

        // Ajout d’un listener global pour détecter le clic hors de la fenêtre
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if (event instanceof MouseEvent e && e.getID() == MouseEvent.MOUSE_PRESSED) {
                    Component clicked = SwingUtilities.getDeepestComponentAt(e.getComponent(), e.getX(), e.getY());
                    if (clicked == null || !SwingUtilities.isDescendingFrom(clicked, JCartePopUp.this)) {
                        dispose(); // ferme la pop-up
                        Toolkit.getDefaultToolkit().removeAWTEventListener(this); // évite fuite mémoire
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);
    }
}

