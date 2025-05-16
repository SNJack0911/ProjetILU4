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

	private static final long serialVersionUID = 1L;

	/**
     * Creates new form PopUp
     * @param parent
     */
    public PopUpVictory(JFrame parent,String winner) {
    	super(parent, true);
    	setContentPane(new VictoryScreen(winner));
    	pack();
    	setLocationRelativeTo(parent);
    	setVisible(true);
    }
}
