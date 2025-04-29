/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package projetpirates;

import boundary.*;
import controleur.*;
import noyau.Jeu;

/**
 *
 * @author yannf
 */
public class ProjetPirates {

    public static void main(String[] args) {
        boolean IHM = true;

        Jeu jeu = new Jeu();
        ControleurNouvellePartie controleurNouvellePartie = new ControleurNouvellePartie(jeu);
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
        BoundaryGetCarteInfo boundaryGetCarteInfo = new BoundaryGetCarteInfo(controleurGetCarteInfo);
        BoundaryGetPirateInfo boundaryGetPirateInfo =  new BoundaryGetPirateInfo(controleurGetPirateInfo);
        BoundaryJouerCarte boundaryJouerCarte = new BoundaryJouerCarte(controleurJouerCarte, controleurGetCarteInfo);
        BoundaryNouvellePartie boundaryNouvellePartie = new BoundaryNouvellePartie(controleurNouvellePartie);
        BoundaryPiocherCarte boundaryPiocherCarte = new BoundaryPiocherCarte(controleurPiocherCarte);


        BoundaryJeu boundaryJeu = new BoundaryJeu(boundaryGetCarteInfo, boundaryGetPirateInfo,
                boundaryJouerCarte, boundaryNouvellePartie, boundaryPiocherCarte);

        if(IHM){
            FrameJeu frameJeu = new FrameJeu(boundaryJeu, false);
            frameJeu.setVisible(true);
        } else {
            boundaryJeu.JouerPartie();
        }

    }
}
