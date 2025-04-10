package boundary.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;


public class Point_de_vie extends javax.swing.JPanel {

    private boolean plein = true; // vrai = cœur plein
    /**
     * Creates new form Zone_d_interaction
     */
    public Point_de_vie() {
        initComponents();
        setPreferredSize(new Dimension(24, 24));
        setOpaque(false);
    }
    
    public void setEtat(boolean plein) {
        this.plein = plein;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(plein ? Color.RED : Color.GRAY);

        int w = getWidth();
        int h = getHeight();
        int demi = w / 2;
        int arcHauteur = h / 2;

        // Demi-cercles du haut
        g2.fillArc(0, 0, demi, arcHauteur, 0, 180);
        g2.fillArc(demi, 0, demi, arcHauteur, 0, 180);

        // Triangle qui part juste sous les arcs
        Polygon triangle = new Polygon();
        triangle.addPoint(0, arcHauteur / 2 );         // bord gauche, coller à la base de l’arc
        triangle.addPoint(w, arcHauteur / 2 );         // bord droit
        triangle.addPoint(demi, h);                   // pointe basse
        g2.fillPolygon(triangle);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
