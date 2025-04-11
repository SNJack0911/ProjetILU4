/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package boundary;

import boundary.components.JCarte;
import boundary.components.JZoneInteraction;
import boundary.components.JPointDeVie;
import boundary.component_manager.GestionnaireCartes;
//import boundary.components.ImagePanel;
import java.awt.Component;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author yannf
 */
public class Plateau1 extends javax.swing.JPanel {

    private JZoneInteraction zoneInteraction = null;
    private JCarte carte;
    private GestionnaireCartes gestionnaire = new GestionnaireCartes();

    /**
     * Creates new form Plateau
     */
    public Plateau1() {
        initComponents();
        /*zoneInteraction = zoneInteraction1;
        carte = jCarte1;
        jCarte1.changeCardFace();
        gestionnaire.ajouterCarte(carte);
        carte = jCarte2;
        gestionnaire.ajouterCarte(carte);
        gestionnaire.ajouterCarte(carte);
        gestionnaire.ajouterZone(zoneInteraction1);
        setNbViesRestantes(4);*/
        //imagePanelJ1.setImage("ressources/Icon12.png");
        //imageJ2.setImage("com/ilu4/jeuxpirate/boundary/ressources/Icon12.png");
        //PopJ1.setImage("com/ilu4/jeuxpirate/boundary/ressources/Icon12.png");
        //PopJ2.setImage("com/ilu4/jeuxpirate/boundary/ressources/Icon12.png");
        //imagePanel1.setImage("/boundary.ressources/blackSmoke00.png");
    }

/*
    public GestionnaireCartes getGestionnaire() {
        return gestionnaire;
    }

    public void verifierZoneInteraction(Rectangle boundsCarte) {
        zoneInteraction1.verifierCarte(carte);
        Rectangle boundsZone = zoneInteraction.getBounds();
        if (boundsZone.intersects(boundsCarte)) {
            //JOptionPane.showMessageDialog(this, "Carte déposée dans la zone !");    // debuggage
        }
    }

    public void setNbViesRestantes(int n) {
        Component[] composants = JaugePoint_de_vie.getComponents();
        for (int i = 0; i < composants.length; i++) {
            if (composants[i] instanceof JPointDeVie coeur) {
                coeur.setEtat(i < n); // les premiers pleins, le reste vides
            }
        }
    }

*/


    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 480, Short.MAX_VALUE)
        );
    }// </editor-fold>                        
/*
        zoneInteraction1 = new boundary.components.JZoneInteraction();
        jCarte2 = new boundary.components.JCarte();
        jCarte1 = new boundary.components.JCarte();
        JaugePoint_de_vie = new javax.swing.JPanel();
        point_de_vie1 = new boundary.components.JPointDeVie();
        point_de_vie2 = new boundary.components.JPointDeVie();
        point_de_vie4 = new boundary.components.JPointDeVie();
        point_de_vie6 = new boundary.components.JPointDeVie();
        point_de_vie10 = new boundary.components.JPointDeVie();
        zoneInteraction2 = new boundary.components.JZoneInteraction();
        zoneInteraction3 = new boundary.components.JZoneInteraction();
        zoneInteraction5 = new boundary.components.JZoneInteraction();
        zoneInteraction6 = new boundary.components.JZoneInteraction();
        zoneInteraction7 = new boundary.components.JZoneInteraction();
        zoneInteraction8 = new boundary.components.JZoneInteraction();
        JaugePoint_de_vie1 = new javax.swing.JPanel();
        point_de_vie3 = new boundary.components.JPointDeVie();
        point_de_vie5 = new boundary.components.JPointDeVie();
        point_de_vie7 = new boundary.components.JPointDeVie();
        point_de_vie8 = new boundary.components.JPointDeVie();
        point_de_vie11 = new boundary.components.JPointDeVie();
        zoneInteraction4 = new boundary.components.JZoneInteraction();
        jLabel1 = new javax.swing.JLabel();
        imageJ1 = new boundary.components.JPanelWithBackground();
        imageJ2 = new boundary.components.JPanelWithBackground();
        PopJ2 = new boundary.components.JPanelWithBackground();
        PopJ1 = new boundary.components.JPanelWithBackground();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        zoneInteraction1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        try{
            jCarte2.setImage("Card1FrontAttack.png");
        } catch (IOException e){
            System.out.print("Card not found");
        }

        javax.swing.GroupLayout jCarte2Layout = new javax.swing.GroupLayout(jCarte2);
        jCarte2.setLayout(jCarte2Layout);
        jCarte2Layout.setHorizontalGroup(
                jCarte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 88, Short.MAX_VALUE)
        );
        jCarte2Layout.setVerticalGroup(
                jCarte2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 128, Short.MAX_VALUE)
        );

        zoneInteraction1.add(jCarte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 90, 130));

        jCarte1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try{
            jCarte1.setImage("Card1FrontAttack.png");
        } catch (IOException e){
            System.out.print("Card not found");
        }

        javax.swing.GroupLayout jCarte1Layout = new javax.swing.GroupLayout(jCarte1);
        jCarte1.setLayout(jCarte1Layout);
        jCarte1Layout.setHorizontalGroup(
                jCarte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 88, Short.MAX_VALUE)
        );
        jCarte1Layout.setVerticalGroup(
                jCarte1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 128, Short.MAX_VALUE)
        );

        zoneInteraction1.add(jCarte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 130));

        add(zoneInteraction1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 460, 150));

        javax.swing.GroupLayout point_de_vie1Layout = new javax.swing.GroupLayout(point_de_vie1);
        point_de_vie1.setLayout(point_de_vie1Layout);
        point_de_vie1Layout.setHorizontalGroup(
                point_de_vie1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie1Layout.setVerticalGroup(
                point_de_vie1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie.add(point_de_vie1);

        javax.swing.GroupLayout point_de_vie2Layout = new javax.swing.GroupLayout(point_de_vie2);
        point_de_vie2.setLayout(point_de_vie2Layout);
        point_de_vie2Layout.setHorizontalGroup(
                point_de_vie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie2Layout.setVerticalGroup(
                point_de_vie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie.add(point_de_vie2);

        javax.swing.GroupLayout point_de_vie4Layout = new javax.swing.GroupLayout(point_de_vie4);
        point_de_vie4.setLayout(point_de_vie4Layout);
        point_de_vie4Layout.setHorizontalGroup(
                point_de_vie4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie4Layout.setVerticalGroup(
                point_de_vie4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie.add(point_de_vie4);

        javax.swing.GroupLayout point_de_vie6Layout = new javax.swing.GroupLayout(point_de_vie6);
        point_de_vie6.setLayout(point_de_vie6Layout);
        point_de_vie6Layout.setHorizontalGroup(
                point_de_vie6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie6Layout.setVerticalGroup(
                point_de_vie6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie.add(point_de_vie6);

        javax.swing.GroupLayout point_de_vie10Layout = new javax.swing.GroupLayout(point_de_vie10);
        point_de_vie10.setLayout(point_de_vie10Layout);
        point_de_vie10Layout.setHorizontalGroup(
                point_de_vie10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie10Layout.setVerticalGroup(
                point_de_vie10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie.add(point_de_vie10);

        add(JaugePoint_de_vie, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 150));

        javax.swing.GroupLayout zoneInteraction2Layout = new javax.swing.GroupLayout(zoneInteraction2);
        zoneInteraction2.setLayout(zoneInteraction2Layout);
        zoneInteraction2Layout.setHorizontalGroup(
                zoneInteraction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 460, Short.MAX_VALUE)
        );
        zoneInteraction2Layout.setVerticalGroup(
                zoneInteraction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 150, Short.MAX_VALUE)
        );

        add(zoneInteraction2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 460, 150));

        zoneInteraction3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout zoneInteraction5Layout = new javax.swing.GroupLayout(zoneInteraction5);
        zoneInteraction5.setLayout(zoneInteraction5Layout);
        zoneInteraction5Layout.setHorizontalGroup(
                zoneInteraction5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        zoneInteraction5Layout.setVerticalGroup(
                zoneInteraction5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );

        zoneInteraction3.add(zoneInteraction5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 160));

        javax.swing.GroupLayout zoneInteraction6Layout = new javax.swing.GroupLayout(zoneInteraction6);
        zoneInteraction6.setLayout(zoneInteraction6Layout);
        zoneInteraction6Layout.setHorizontalGroup(
                zoneInteraction6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        zoneInteraction6Layout.setVerticalGroup(
                zoneInteraction6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );

        zoneInteraction3.add(zoneInteraction6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 100, 160));

        javax.swing.GroupLayout zoneInteraction7Layout = new javax.swing.GroupLayout(zoneInteraction7);
        zoneInteraction7.setLayout(zoneInteraction7Layout);
        zoneInteraction7Layout.setHorizontalGroup(
                zoneInteraction7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        zoneInteraction7Layout.setVerticalGroup(
                zoneInteraction7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );

        zoneInteraction3.add(zoneInteraction7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 100, 160));

        javax.swing.GroupLayout zoneInteraction8Layout = new javax.swing.GroupLayout(zoneInteraction8);
        zoneInteraction8.setLayout(zoneInteraction8Layout);
        zoneInteraction8Layout.setHorizontalGroup(
                zoneInteraction8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        zoneInteraction8Layout.setVerticalGroup(
                zoneInteraction8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 160, Short.MAX_VALUE)
        );

        zoneInteraction3.add(zoneInteraction8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 100, 160));

        add(zoneInteraction3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 460, 180));

        javax.swing.GroupLayout point_de_vie3Layout = new javax.swing.GroupLayout(point_de_vie3);
        point_de_vie3.setLayout(point_de_vie3Layout);
        point_de_vie3Layout.setHorizontalGroup(
                point_de_vie3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie3Layout.setVerticalGroup(
                point_de_vie3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie1.add(point_de_vie3);

        javax.swing.GroupLayout point_de_vie5Layout = new javax.swing.GroupLayout(point_de_vie5);
        point_de_vie5.setLayout(point_de_vie5Layout);
        point_de_vie5Layout.setHorizontalGroup(
                point_de_vie5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie5Layout.setVerticalGroup(
                point_de_vie5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie1.add(point_de_vie5);

        javax.swing.GroupLayout point_de_vie7Layout = new javax.swing.GroupLayout(point_de_vie7);
        point_de_vie7.setLayout(point_de_vie7Layout);
        point_de_vie7Layout.setHorizontalGroup(
                point_de_vie7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie7Layout.setVerticalGroup(
                point_de_vie7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie1.add(point_de_vie7);

        javax.swing.GroupLayout point_de_vie8Layout = new javax.swing.GroupLayout(point_de_vie8);
        point_de_vie8.setLayout(point_de_vie8Layout);
        point_de_vie8Layout.setHorizontalGroup(
                point_de_vie8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie8Layout.setVerticalGroup(
                point_de_vie8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie1.add(point_de_vie8);

        javax.swing.GroupLayout point_de_vie11Layout = new javax.swing.GroupLayout(point_de_vie11);
        point_de_vie11.setLayout(point_de_vie11Layout);
        point_de_vie11Layout.setHorizontalGroup(
                point_de_vie11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );
        point_de_vie11Layout.setVerticalGroup(
                point_de_vie11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 24, Short.MAX_VALUE)
        );

        JaugePoint_de_vie1.add(point_de_vie11);

        add(JaugePoint_de_vie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 30, 150));

        jLabel1.setText("Pioche");

        javax.swing.GroupLayout zoneInteraction4Layout = new javax.swing.GroupLayout(zoneInteraction4);
        zoneInteraction4.setLayout(zoneInteraction4Layout);
        zoneInteraction4Layout.setHorizontalGroup(
                zoneInteraction4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(zoneInteraction4Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        zoneInteraction4Layout.setVerticalGroup(
                zoneInteraction4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(zoneInteraction4Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addContainerGap(135, Short.MAX_VALUE))
        );

        add(zoneInteraction4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 130, 180));

        try{
            imageJ1.setImage("IconJ1.png");
        }catch (IOException e) {
            String userDirectory = new File("").getAbsolutePath();
            System.out.print("Background not found"); // or handle the error
        }
        imageJ1.repaint();

        javax.swing.GroupLayout imageJ1Layout = new javax.swing.GroupLayout(imageJ1);
        imageJ1.setLayout(imageJ1Layout);
        imageJ1Layout.setHorizontalGroup(
                imageJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 130, Short.MAX_VALUE)
        );
        imageJ1Layout.setVerticalGroup(
                imageJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 150, Short.MAX_VALUE)
        );

        add(imageJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, 150));

        try{
            imageJ2.setImage("IconJ2.png");
        }catch (IOException e) {
            String userDirectory = new File("").getAbsolutePath();
            System.out.print("Background not found"); // or handle the error
        }
        imageJ2.repaint();

        javax.swing.GroupLayout imageJ2Layout = new javax.swing.GroupLayout(imageJ2);
        imageJ2.setLayout(imageJ2Layout);
        imageJ2Layout.setHorizontalGroup(
                imageJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 130, Short.MAX_VALUE)
        );
        imageJ2Layout.setVerticalGroup(
                imageJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 150, Short.MAX_VALUE)
        );

        add(imageJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 150));

        try{
            PopJ2.setImage("Icon12.png");
        }catch (IOException e) {
            String userDirectory = new File("").getAbsolutePath();
            System.out.print("Background not found"); // or handle the error
        }
        PopJ2.repaint();

        javax.swing.GroupLayout PopJ2Layout = new javax.swing.GroupLayout(PopJ2);
        PopJ2.setLayout(PopJ2Layout);
        PopJ2Layout.setHorizontalGroup(
                PopJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        PopJ2Layout.setVerticalGroup(
                PopJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 150, Short.MAX_VALUE)
        );

        add(PopJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 100, 150));

        try{
            PopJ1.setImage("Icon23.png");
        }catch (IOException e) {
            String userDirectory = new File("").getAbsolutePath();
            System.out.print("Background not found"); // or handle the error
        }
        PopJ1.repaint();

        javax.swing.GroupLayout PopJ1Layout = new javax.swing.GroupLayout(PopJ1);
        PopJ1.setLayout(PopJ1Layout);
        PopJ1Layout.setHorizontalGroup(
                PopJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        PopJ1Layout.setVerticalGroup(
                PopJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 150, Short.MAX_VALUE)
        );

        add(PopJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 150));
       */


    // Variables declaration - do not modify//GEN-BEGIN:variables

    // End of variables declaration//GEN-END:variables

    /*private javax.swing.JPanel JaugePoint_de_vie;
    private javax.swing.JPanel JaugePoint_de_vie1;
    private boundary.components.JPanelWithBackground PopJ1;
    private boundary.components.JPanelWithBackground PopJ2;
    private boundary.components.JPanelWithBackground imageJ1;
    private boundary.components.JPanelWithBackground imageJ2;
    private boundary.components.JCarte jCarte1;
    private boundary.components.JCarte jCarte2;
    private javax.swing.JLabel jLabel1;
    private boundary.components.JPointDeVie point_de_vie1;
    private boundary.components.JPointDeVie point_de_vie10;
    private boundary.components.JPointDeVie point_de_vie11;
    private boundary.components.JPointDeVie point_de_vie2;
    private boundary.components.JPointDeVie point_de_vie3;
    private boundary.components.JPointDeVie point_de_vie4;
    private boundary.components.JPointDeVie point_de_vie5;
    private boundary.components.JPointDeVie point_de_vie6;
    private boundary.components.JPointDeVie point_de_vie7;
    private boundary.components.JPointDeVie point_de_vie8;
    private boundary.components.JZoneInteraction zoneInteraction1;
    private boundary.components.JZoneInteraction zoneInteraction2;
    private boundary.components.JZoneInteraction zoneInteraction3;
    private boundary.components.JZoneInteraction zoneInteraction4;
    private boundary.components.JZoneInteraction zoneInteraction5;
    private boundary.components.JZoneInteraction zoneInteraction6;
    private boundary.components.JZoneInteraction zoneInteraction7;
    private boundary.components.JZoneInteraction zoneInteraction8;*/
}
