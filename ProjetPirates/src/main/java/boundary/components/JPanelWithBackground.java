/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.*;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author yannf
 */
public class JPanelWithBackground extends JPanel {

    private Image backgroundImage;


    public JPanelWithBackground(){
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the background image.
        if(backgroundImage != null){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(backgroundImage, 0,0, getWidth(), getHeight(), this);
        }

    }

    public void setImage(String fileName) throws IOException {
        backgroundImage = ImageIO.read(new File("src/main/java/com/ilu4/jeuxpirate/boundary/ressources/" + fileName));
        //backgroundImage = ImageIO.read(new File(fileName));

    }
}

