/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary.components;

import boundary.Plateau;

import java.awt.*;
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
import noyau.GestionnaireEffetFumee;
import noyau.ICategorieCarte;


/**
 *
 * @author leo et yannf
 */
public class JCarte extends javax.swing.JPanel {
    private Image frontCard;
    private Image backCard;
    private boolean isFront = false;
    private Point origine = null;
    //private boolean isSelected = false;
    private JCartePopUp popUp = null;
    private JMainJoueur mainOrigine; 
    
    private String nom;
    private int carteID; // never read ?
    private ICategorieCarte type;
    private String description;
    private BasicCategorie zoneDepot;
    
    private final List<SmokeEffect> fumees = new ArrayList<>();
    private final GestionnaireEffetFumee effets = new GestionnaireEffetFumee();
    private Timer timerFumee;

    
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
        this.carteID = 0;
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


    
    @Override 
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       
        if(isFront && frontCard != null){
            g2d.drawImage(frontCard, 0,0, getWidth(), getHeight(), this);
            super.paintComponent(g);
        }else if (backCard != null){
            g2d.drawImage(backCard, 0,0, getWidth(), getHeight(), this);
        }
       
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
    
    public void setImage(int carteID) {
        try {
            backCard = ImageIO.read(new File("src/main/resources/" + "Card1Back.png"));
            if (carteID == -1){
                frontCard = ImageIO.read(new File("src/main/resources/Carte/Card1Front" + type.toString() + ".png"));
            }else{
                frontCard = ImageIO.read(new File("src/main/resources/Carte/Card1Front" + carteID + ".png"));
            }
        } catch (IOException e){
            String userDirectory = new File("").getAbsolutePath();
            System.out.println("Card not found : " + userDirectory + "src/main/resources/Carte/Card1Front" + type.toString() + ".png");
            System.out.println("Card ID : " + carteID + "\tIHM : " + type.toString());
        }
        //this.nom = cardName;
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
            .addGap(0, 136, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        //System.out.println("MousePressed");
        if (!isFront || !isEnabled()) return;
        
        this.origine = evt.getPoint();
	//this.isSelected = true;
        Plateau plateauPanel = (Plateau) mainOrigine.getParent().getParent();
        plateauPanel.setComponentZOrder(this, 0);

        repaint();
        
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (!isFront || !isEnabled()) return;
        
        origine = null;
	//this.isSelected = false;
        
        JPanel plateauPanel = (JPanel) mainOrigine.getParent();
        Plateau plateau = (Plateau) plateauPanel.getParent();
        Point pointInPlateau = SwingUtilities.convertPoint(this, evt.getPoint(), plateauPanel);

        Component c = plateauPanel.getComponentAt(pointInPlateau);
        //System.out.println("C: " + c.getClass().getSimpleName());
        
        if (c instanceof JZoneInteraction zoneInteraction){
            Rectangle boundsZone = zoneInteraction.getBounds();
            if (boundsZone.intersects(getBounds())) {
                String pirate = plateau.getCurrentPirate();
                boolean res = zoneInteraction.ajouteCarte(this, pointInPlateau, plateauPanel, pirate);
                if(res){//dispose
                    plateau.jouerTour(this);
                    plateau.remove(this);
                    plateau.revalidate();
                    plateau.repaint();
                    
                    return;
                }
            }
        }
        //System.out.println("Not dropped on a drop zone.");
        //Return Carte to Main
        if (mainOrigine != null) {
            mainOrigine.ajouterJCarte(this);
            plateauPanel.repaint();
        }
        
    }//GEN-LAST:event_formMouseReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //System.out.println("MouseClicked");
        if (!isFront) return;
        
        if (SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2 && isFront && frontCard != null) {
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
        if (!isFront || !isEnabled()) return;
        
        if (origine != null) {
            	    // Ajoute une fumée sur le plateau
            Container parent = SwingUtilities.getAncestorOfClass(Plateau.class, this);
            if (parent instanceof Plateau plateau) {
                Point global = SwingUtilities.convertPoint(this, getCentreCarte(), plateau);
                effets.ajouterFumee(global.x, global.y); //plateau.getGestionnaireEffetsFumee().ajouterFumee(global.x, global.y);
                }
            lancerFumee();
            // Move card
            int xMoved = evt.getX() - origine.x;
            int yMoved = evt.getY() - origine.y;
            this.setLocation(this.getX() + xMoved, this.getY() + yMoved);

            // Repaint only nearby overlapping cards
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
