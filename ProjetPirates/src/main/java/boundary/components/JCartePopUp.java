package boundary.components;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Image;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author leo
 */

public class JCartePopUp extends JWindow {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

