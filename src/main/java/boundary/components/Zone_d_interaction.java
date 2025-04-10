/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author choue
 */
public class Zone_d_interaction extends javax.swing.JPanel {

    private boolean carteDedans = false;
    /**
     * Creates new form Zone_d_interaction
     */
    public Zone_d_interaction() {
        initComponents();
        //setBackground(Color.PINK);
        setBounds(500,200,150,150);
    }
    
    @SuppressWarnings("unchecked")
    
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;

    g2.setColor(carteDedans ? Color.BLUE : Color.PINK);
    g2.fillRect(0, 0, getWidth(), getHeight());

    //g2.setColor(Color.BLACK);
    //g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
}

// Méthode pour vérifier si une carte a été déposée dans la zone
    public void verifierCarte(JCarte carte) {
        Point centre = carte.getCentreCarte();
        Rectangle zone = this.getBounds();

        boolean dedans = zone.contains(centre);
        if (dedans != carteDedans) {
            carteDedans = dedans;
            repaint();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
