/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package boundary.components;

import javax.swing.JFrame;

/**
 *
 * @author Hai
 */
public class PopUpVictory extends javax.swing.JDialog {

    /**
     * Creates new form PopUp
     * @param parent
     */
	private String winner;
    public PopUpVictory(JFrame parent,String winner) {
    	super(parent, true);
    	setContentPane(new VictoryScreen(winner));
    	pack();                    // size to VictoryScreen’s preferred size
    	setLocationRelativeTo(parent);
    	setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
