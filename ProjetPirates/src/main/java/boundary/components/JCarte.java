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
        if (fumeeDejaEnCours()) return;

        timerFumee = new Timer(150, e -> {
            if (getParent() == null) return;
            Point positionCarte = calculerPositionSurPlateau();

            ajouterNouvelleFumee(positionCarte);
            mettreAJourFumees();
            repaint();
        });
        timerFumee.start();
    }

    private boolean fumeeDejaEnCours() {
        return timerFumee != null && timerFumee.isRunning();
    }

    private Point calculerPositionSurPlateau() {
        JPanel plateauPanel = (JPanel) mainOrigine.getParent();
        return SwingUtilities.convertPoint(this, getWidth() / 2, getHeight() / 2, plateauPanel);
    }

    private void ajouterNouvelleFumee(Point position) {
        Image img = effets.getRandomImage();
        if (img != null) {
            fumees.add(new SmokeEffect(img, position.x, position.y));
        }
    }

    private void mettreAJourFumees() {
        for (SmokeEffect f : fumees) {
            f.diminuerAlpha(0.05f);
        }
        fumees.removeIf(SmokeEffect::estTerminee);
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

        if (gererInteractionZone(c, pointInPlateau, plateauPanel, plateau)) return;
        // Renvoyer dans la main si non joué
        if (mainOrigine != null) gererMainDrop(evt);
 
        if (mainOrigine != null && !mainOrigine.getMainJoueur().contains(this)) {
            mainOrigine.ajouterJCarte(this);
        }
        plateauPanel.repaint();
        
    }//GEN-LAST:event_formMouseReleased

    private boolean gererInteractionZone(Component c, Point pointInPlateau, JPanel plateauPanel, Plateau plateau) {
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

    private void gererMainDrop(MouseEvent evt) {
        Point dropPoint = SwingUtilities.convertPoint(this, evt.getPoint(), mainOrigine);
        Component comp = mainOrigine.getComponentAt(dropPoint);
        List<JCarte> main = mainOrigine.getMainJoueur();
        main.remove(this);

        if (comp instanceof JCarte autreCarte) {
            insererPresDe(autreCarte,main);
        } else {
            int fallbackIndex = (indexOrigineMain >= 0 && indexOrigineMain <= main.size()) ? indexOrigineMain : main.size();
            main.add(fallbackIndex, this);
        }
        
        mainOrigine.setGridCartes();
    }
    
    private void insererPresDe(JCarte autreCarte, List<JCarte> main) {
        int index = main.indexOf(autreCarte);
        if (index != -1) {
            int nouvelIndex = Math.min(index + 1, main.size());
            main.add(nouvelIndex, this);
        } else {
            main.add(this);
        }
    }
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (!isFront) return;

    if (clicGaucheDouble(evt) && frontCard != null) {
        JFrame fenetreParente = (JFrame) SwingUtilities.getWindowAncestor(JCarte.this);
        fermerAnciennePopUpSiExiste();
        afficherCarteZoomee(fenetreParente);
    }
    }//GEN-LAST:event_formMouseClicked

    private boolean clicGaucheDouble(MouseEvent evt) {
        return SwingUtilities.isLeftMouseButton(evt) && evt.getClickCount() == 2;
    }

    private void fermerAnciennePopUpSiExiste() {
        if (popUp != null) {
            popUp.dispose();
        }
    }

    private void afficherCarteZoomee(JFrame fenetreParente) {
        int hauteur = fenetreParente.getHeight() - 80;
        int largeur = (int) (hauteur * 0.72);
        Image imageZoom = frontCard.getScaledInstance(largeur, hauteur, Image.SCALE_SMOOTH);
        popUp = new JCartePopUp(fenetreParente, imageZoom);
    }


    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        if (!isFront || !isEnabled() || origine != null) return;

        genererEffetsFumee();
        deplacerCarte(evt);
        repeindreCartesChevauchantes();
        repaint();
        
    }//GEN-LAST:event_formMouseDragged

    
    private void genererEffetsFumee() {
        Container parent = SwingUtilities.getAncestorOfClass(Plateau.class, this);
        if (parent instanceof Plateau plateau) {
            Point global = SwingUtilities.convertPoint(this, getCentreCarte(), plateau);
            effets.ajouterFumee(global.x, global.y);
        }
        lancerFumee();
    }

    private void deplacerCarte(MouseEvent evt) {
        int xMoved = evt.getX() - origine.x;
        int yMoved = evt.getY() - origine.y;
        setLocation(getX() + xMoved, getY() + yMoved);
    }

    private void repeindreCartesChevauchantes() {
        Rectangle bounds = getBounds();
        for (Component comp : getParent().getComponents()) {
            if (comp instanceof JCarte && comp != this && comp.getBounds().intersects(bounds)) {
                comp.repaint();
            }
        }
    }
    
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
