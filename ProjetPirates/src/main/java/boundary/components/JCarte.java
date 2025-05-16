/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.components;

import boundary.Plateau;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import noyau.BasicCategorie;
import noyau.ICategorieCarte;


/**
 *
 * @author leo et yannf, retouche vincent
 */
public class JCarte extends javax.swing.JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient Image frontCard;
    private transient Image backCard;
    private boolean isFront = false;
    private Point origine = null;
    private JCartePopUp popUp = null;
    private JMainJoueur mainOrigine; 
    
    private String nom;
    private transient ICategorieCarte type;
    private String description;
    private BasicCategorie zoneDepot;
    
    private final List<SmokeEffect> fumees = new ArrayList<>();
    private final transient GestionnaireEffetFumee effets = new GestionnaireEffetFumee();
    private Timer timerFumee;

    private int indexOrigineMain = -1;
    
    /**
     * Creates new form JCarte
     */
    public JCarte() {
        initComponents();
        double w = getWidth();
        double h = w*1.4;
        setSize((int)w, (int)h);
    }

    public void ajouterAttribut(String nom, int carteID, ICategorieCarte type, String description, BasicCategorie zoneDepot, JMainJoueur mainOrigine){
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.zoneDepot = zoneDepot;
        this.mainOrigine = mainOrigine;
        
        setImage(carteID);
    }
    
    public void lancerFumee() {
        if (timerFumee != null && timerFumee.isRunning()) return;

        timerFumee = new Timer(150, e -> {
            if (getParent() == null) return;

            JPanel plateauPanel = (JPanel) mainOrigine.getParent();
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
       
        for (SmokeEffect smoke : fumees) {
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, smoke.alpha));
            g2d.drawImage(smoke.image, smoke.x - getX(), smoke.y - getY(), 40, 40, this); // taille ajustable
        }
        
        g2d.dispose();
    }
    
    public Point getCentreCarte() {
        return new Point(getX() + getWidth() / 2, getY() + getHeight() / 2);
    }
    
    public void changeCardFace(){
        isFront = !isFront;
    }
    
    public void setImage(int carteID) {
        String basePath = "src/main/resources/";
        try {
            backCard = ImageIO.read(new File(basePath + "Card1Back.png"));

            String frontCardPath;
            if (carteID == -1) {
                frontCardPath = basePath + "Carte/Card1Front" + type + ".png";
            } else {
                frontCardPath = basePath + "Carte/Card1Front" + carteID + ".png";
            }

            frontCard = ImageIO.read(new File(frontCardPath));

        } catch (IOException e) {
            String userDirectory = new File("").getAbsolutePath();
            System.out.printf("Card not found: {}src/main/resources/Carte/Card1Front{}.png", userDirectory, carteID == -1 ? type : carteID, e);
            System.out.printf("Card ID: {}\tIHM type: {}", carteID, type);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (mainOrigine != null) {
            indexOrigineMain = mainOrigine.getMainJoueur().indexOf(this);
        }
        if (!isFront || !isEnabled()) return;

        this.origine = evt.getPoint();
        Plateau plateauPanel = (Plateau) mainOrigine.getParent().getParent();
        plateauPanel.setComponentZOrder(this, 0); 
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (!isFront || !isEnabled()) return;
        origine = null;
        
        JPanel plateauPanel = (JPanel) mainOrigine.getParent();
        Plateau plateau = (Plateau) plateauPanel.getParent();
        Point pointInPlateau = SwingUtilities.convertPoint(this, evt.getPoint(), plateauPanel);
        Component c = plateauPanel.getComponentAt(pointInPlateau);

        if (handleZoneInteraction(c, pointInPlateau, plateauPanel, plateau)) return;
        // Renvoyer dans la main si non joué
        if (mainOrigine != null) handleMainDrop(evt);
 
        if (mainOrigine != null && !mainOrigine.getMainJoueur().contains(this)) {
            mainOrigine.ajouterJCarte(this);
        }
        plateauPanel.repaint();
        
    }//GEN-LAST:event_formMouseReleased

    private boolean handleZoneInteraction(Component c, Point pointInPlateau, JPanel plateauPanel, Plateau plateau) {
        if (c instanceof JZoneInteraction zoneInteraction) {
            Rectangle boundsCarte = SwingUtilities.convertRectangle(this.getParent(), this.getBounds(), plateauPanel);
            Rectangle boundsZone = zoneInteraction.getBounds();

            if (boundsZone.intersects(boundsCarte)) {
                String pirate = plateau.getCurrentPirate();
                boolean res = zoneInteraction.ajouteCarte(this, pointInPlateau, plateauPanel, pirate);
                if (res) {
                    plateau.jouerTour(this);
                    plateau.remove(this);
                    plateau.revalidate();
                    plateau.repaint();
                    return true;
                }
            }
        }
        return false;
    }

    private void handleMainDrop(MouseEvent evt) {
        Point dropPoint = SwingUtilities.convertPoint(this, evt.getPoint(), mainOrigine);
        Component comp = mainOrigine.getComponentAt(dropPoint);

        List<JCarte> main = mainOrigine.getMainJoueur();
        main.remove(this);

        if (comp instanceof JCarte other) {
            int index = main.indexOf(other);
            if (index != -1) {
                int newIndex = Math.min(index + 1, main.size());
                main.add(newIndex, this);
            } else {
                main.add(this);
            }
        } else {
            int fallbackIndex = (indexOrigineMain >= 0 && indexOrigineMain <= main.size()) ? indexOrigineMain : main.size();
            main.add(fallbackIndex, this);
        }
        
        mainOrigine.setGridCartes();
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (!isFront) return;
        
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2 && frontCard != null) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(JCarte.this);

            if (popUp != null) { // si une précédente pop-up traîne
                popUp.dispose(); 
            }

            // Crée une image agrandie pour le zoom
            int height = parentFrame.getHeight() - 80;
            int width = (int) (height * 0.72);

            Image scaledImage = frontCard.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            popUp = new JCartePopUp(parentFrame, scaledImage);
        }
    }//GEN-LAST:event_formMouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (!isFront || !isEnabled()) return;
        
        if (origine != null) {
            	    // Ajoute une fumée sur le plateau
            Container parent = SwingUtilities.getAncestorOfClass(Plateau.class, this);
            if (parent instanceof Plateau plateau) {
                Point global = SwingUtilities.convertPoint(this, getCentreCarte(), plateau);
                effets.ajouterFumee(global.x, global.y); 
            }
            lancerFumee();
            
            // Move card
            int xMoved = evt.getX() - origine.x;
            int yMoved = evt.getY() - origine.y;
            this.setLocation(this.getX() + xMoved, this.getY() + yMoved);

            // Repeindre uniquement les cartes qui se chevauchent à proximite
            Rectangle bounds = this.getBounds();
            for (Component comp : getParent().getComponents()) {
                if (comp instanceof JCarte && comp != this && comp.getBounds().intersects(bounds)) {
                    comp.repaint();
                }
            }

            // Minimal repaint
            this.repaint();
        }
    }//GEN-LAST:event_formMouseDragged

    public String getNomCarte() {
        return nom;
    }

    public Image getImage(){
        return frontCard;
    }
    
    public ICategorieCarte getType(){
        return type;
    }

    public BasicCategorie getCategorie(){return zoneDepot;}

    public String getDescription() {
        return description;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
