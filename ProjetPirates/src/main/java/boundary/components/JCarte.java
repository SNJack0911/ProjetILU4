/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.components;

import boundary.Plateau;
import boundary.components.JCartePopUp;
import java.awt.AlphaComposite;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import noyau.CategorieCarte;

/**
 *
 * @author choue
 */
public class JCarte extends javax.swing.JPanel {
    private Image frontCard;
    private Image backCard;
    private boolean isFront = false;
    private Point origine = null;
    private boolean isSelected = false;
    private JCartePopUp popUp = null;
    private JMainJoueur mainOrigine; 
    
    private String nom;
    private CategorieCarte type;
    private String description;
    
    private final List<SmokeEffect> fumées = new ArrayList<>();
    private final GestionnaireEffetFumee effets = new GestionnaireEffetFumee();
    private Timer timerFumee;
    private final List<SmokeEffect> fumees = new ArrayList<>();
    
    public void lancerFumee() {
        if (timerFumee != null && timerFumee.isRunning()) return;
        timerFumee = new Timer(150, e -> {
            if (getParent() == null) return;

            JPanel plateauPanel = (JPanel) mainOrigine.getParent(); // utilise le même système que ton release
            Point carteSurPlateau = SwingUtilities.convertPoint(this, getWidth()/2, getHeight()/2, plateauPanel);

            Image img = effets.getRandomImage();
            if (img != null) {
                fumees.add(new SmokeEffect(img, carteSurPlateau.x, carteSurPlateau.y));
            }

            for (SmokeEffect f : fumees) {
                f.diminuerAlpha(0.05f);
            }

            fumees.removeIf(SmokeEffect::estTerminee);
            repaint();
        });
        timerFumee.start();
    }
    
    /**
     * Creates new form JCarte
     */
    public JCarte() {
        initComponents();
        this.setDoubleBuffered(true);
        double w = getWidth();
        double h = w*1.4;
        setSize((int)w, (int)h);
    }

    public void ajouterAttribut(String nom, CategorieCarte type, String description, JMainJoueur mainOrigine){
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.mainOrigine = mainOrigine;
        setImage("Card1Front" + type.toString() + ".png");

    }
    
    public void lancerFumée() {
        if (timerFumee != null && timerFumee.isRunning()) return;

        timerFumee = new Timer(150, e -> {
            Image img = effets.getRandomImage();
            if (img != null) {
                Point centre = getCentreCarte();
                fumées.add(new SmokeEffect(img, centre.x, centre.y));
            }

            // Diminue la transparence
            for (SmokeEffect f : fumées) {
                f.diminuerAlpha(0.05f);
            }

            // Nettoie les fumées finies
            fumées.removeIf(SmokeEffect::estTerminee);

            repaint();
        });
        timerFumee.start();
    }
    
    @Override 
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        if(isFront && frontCard != null){
            g2d.drawImage(frontCard, 0,0, getWidth(), getHeight(), this);
        }else if (backCard != null){
            g2d.drawImage(backCard, 0,0, getWidth(), getHeight(), this);
        }
        

	// Dessin des fumées
        for (SmokeEffect smoke : fumees) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, smoke.alpha));
            g2d.drawImage(smoke.image, smoke.x - getX(), smoke.y - getY(), 40, 40, this); // taille ajustable
        }
        g2d.dispose();
        
    }
    
    //Projet pour faire les effet de particule    
    public void deplacerVers(int xFinal, int yFinal) {
        Timer timer = new Timer(10, null);
        timer.addActionListener(e -> {
            int x = getX();
            int y = getY();
            int dx = (xFinal - x) / 5;
            int dy = (yFinal - y) / 5;

            if (Math.abs(xFinal - x) < 2 && Math.abs(yFinal - y) < 2) {
                setLocation(xFinal, yFinal);
                timer.stop();
            } else {
                setLocation(x + dx, y + dy);
            }
        });
        timer.start();
    }
    
    public Point getCentreCarte() {
        return new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);
    }
    
    public void changeCardFace(){
        isFront = !isFront;
    }
    
    public void setImage(String cardName) {
        try {
            backCard = ImageIO.read(new File("src/main/ressources/" + "Card1Back.png"));
            frontCard = ImageIO.read(new File("src/main/ressources/" + cardName));
        } catch (IOException e){
            String userDirectory = new File("").getAbsolutePath();
            System.out.print("Card not found : " + userDirectory);
        }
        this.nom = cardName;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        //System.out.println("MousePressed");      
        if (evt.getClickCount()>1){return;}
        
        this.origine = evt.getPoint();
	this.isSelected = true;
        
        JPanel plateauPanel = (JPanel) mainOrigine.getParent();
        JLayeredPane layer = JLayeredPane.getLayeredPaneAbove(plateauPanel);

        Component[] components = layer.getComponents();
        for (Component c : components) {
            if (c instanceof JPanel panel && "TranparentLayer".equals(panel.getName())) {
                
                
                // Step 1: Convert location before removing
                Point cardLoc = SwingUtilities.convertPoint(this.getParent(), this.getLocation(), panel);

                // Step 2: Remove from current parent first
                Container oldParent = this.getParent();
                if (oldParent != null) {
                    oldParent.remove(this);
                    oldParent.revalidate();
                    oldParent.repaint();
                }

                // Step 3: Add to transparent panel
                this.setLocation(cardLoc);
                this.setSize(this.getPreferredSize());
                this.setOpaque(true);
                panel.add(this);
                panel.setComponentZOrder(this, 0);
                panel.revalidate();
                panel.repaint();
                
            }
        }

        layer.repaint();
        
        //SwingUtilities.getWindowAncestor(this).setComponentZOrder(this, 0);
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        origine = null;
	this.isSelected = false;
        
        JPanel plateauPanel = (JPanel) mainOrigine.getParent();
        Point pointInPlateau = SwingUtilities.convertPoint(this, evt.getPoint(), plateauPanel);

        Component c = plateauPanel.getComponentAt(pointInPlateau);
        JLayeredPane layer = (JLayeredPane.getLayeredPaneAbove(plateauPanel));
        Plateau p = (Plateau) layer.getParent();
        

        if (c instanceof JZoneInteraction dropZone) {
            String pirate = p.getCurrentPirate();
            boolean res = dropZone.ajouteCarte(this, pointInPlateau, plateauPanel, pirate);
            if(res){//dispose
                Container parent = this.getParent();
                //System.out.println("Parent of card: " + parent.getClass().getSimpleName());
                if (parent != null) {
                    parent.remove(this);
                    parent.revalidate();
                    parent.repaint();
                }
                return;
            }  
        }
        System.out.println("Not dropped on a drop zone.");
        //Retrun Carte to Main
        if (mainOrigine != null) {
            mainOrigine.ajouterJCarte(this);
        }
      
        /*origine = null;
	this.isSelected = false;
        repaint();
        //Container root = SwingUtilities.getWindowAncestor(this);
        if (root instanceof Plateau plateau) {
            plateau.getGestionnaire().verifierToutesZones(this); // C’est bien la méthode du gestionnaire
        }*/
        //détecte pas getGestionnaire ?
    }//GEN-LAST:event_formMouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //System.out.println("MouseClicked");
        if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt) && isFront && frontCard != null) {
            //System.out.println("DoubleClick + is front : " + isFront);
                    JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(JCarte.this);

                    if (popUp != null) {
                        popUp.dispose(); // si une précédente pop-up traîne
                    }

                    // Crée une image agrandie pour le zoom
                    int width = frontCard.getWidth(this);
                    int height = frontCard.getHeight(this);
                    if (width <= 0 || height <= 0) {
                        width = 100;
                        height = 150;
                    }
                    Image scaledImage = frontCard.getScaledInstance(width * 3, height * 3, Image.SCALE_SMOOTH);

                    popUp = new JCartePopUp(parentFrame, scaledImage);
        }
    }//GEN-LAST:event_formMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (origine != null){
            Container parent = SwingUtilities.getAncestorOfClass(Plateau.class, this);
            if (parent instanceof Plateau plateau) {
                Point global = SwingUtilities.convertPoint(this, getCentreCarte(), plateau);
                effets.ajouterFumee(global.x, global.y); //plateau.getGestionnaireEffetsFumee().ajouterFumee(global.x, global.y);
                }
            lancerFumee(); 
            Point mouseInScreen = evt.getLocationOnScreen();
            JLayeredPane layeredPane = JLayeredPane.getLayeredPaneAbove(this);
            SwingUtilities.convertPointFromScreen(mouseInScreen, layeredPane); // modifies in-place

            this.setLocation(mouseInScreen.x - origine.x, mouseInScreen.y - origine.y);
            //this.repaint();
            /*int thisX = this.getLocation().x;
            int thisY = this.getLocation().y;

            int xMoved = evt.getX() - origine.x;
            int yMoved = evt.getY() - origine.y;

            int X = thisX + xMoved;
            int Y = thisY + yMoved;

            this.setLocation(X, Y);
            this.repaint();*/
            // regle affichage des élements en dessous de la carte
            /*for (Component comp : getParent().getComponents()) {
                if (comp instanceof JCarte && comp != this) {
                    comp.repaint(); // Force les autres cartes à se redessiner si touchées
                }
            }*/
        }
    }//GEN-LAST:event_formMouseDragged

    public String getNomCarte() {
        return nom;
    }

    public Image getImage(){
        return frontCard;
    }
    
    public CategorieCarte getType(){
        return type;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
