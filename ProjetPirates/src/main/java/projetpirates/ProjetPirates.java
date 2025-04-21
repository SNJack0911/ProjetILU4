/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package projetpirates;

import boundary.BoundaryJeu;
import boundary.FrameJeu;
import controleur.*;
import noyau.Jeu;

/**
 *
 * @author yannf
 */
public class ProjetPirates {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        ControleurNouvellePartie controleurLancerJeu = new ControleurNouvellePartie(jeu);
        ControleurPiocherCarte controleurPiocherCarte = new ControleurPiocherCarte(jeu);
        ControleurJouerCarte controleurJouerCarte = new ControleurJouerCarte(jeu);
        ControleurGetCarteInfo controleurGetCarteInfo = new ControleurGetCarteInfo(jeu);
        ControleurGetPirateInfo controleurGetPirateInfo = new ControleurGetPirateInfo(jeu);

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>



        BoundaryJeu boundaryJeu = new BoundaryJeu(controleurLancerJeu, controleurPiocherCarte
                , controleurJouerCarte, controleurGetCarteInfo,
                controleurGetPirateInfo);

        FrameJeu frameJeu = new FrameJeu(boundaryJeu, false);

        frameJeu.setVisible(true);

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJeu(boundaryJeu, false).setVisible(true);
            }
        });*/


        
        
    }
}
