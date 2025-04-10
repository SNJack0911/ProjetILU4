package boundary.components;
//--------------------------------------------------------------------
// C'est pour mettre des images !!!!!
// -------------------------------------------------------------------
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ImagePanel extends javax.swing.JPanel {
    private Image image;

    public void setImage(String imagePath) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        image = icon.getImage();
        repaint(); // Force la redessination quand une image est chargée
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            // Redimensionne proprement à la taille actuelle du panel
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

