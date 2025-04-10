/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author yannf
 */
public class JButtonCustom extends JButton{
    private Image defaultIcon = null;
    private Image pressedIcon = null;
    private boolean isPressed = false;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        // Draw the background image.
        if(isPressed && pressedIcon != null){    
            g2d.drawImage(pressedIcon, 0, 0, getWidth(), getHeight(), this);
        } else if(defaultIcon != null ){
            g2d.drawImage(defaultIcon, 0, 0, getWidth(), getHeight(), this);
        }
        super.paintComponent(g);
    }
    
    public void setImage() throws IOException {
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }
        });
        
        setIcon();
    }
    
    private void setIcon() throws IOException{
        defaultIcon = ImageIO.read(new File("src/main/java/com/ilu4/jeuxpirate/boundary/ressources/ButtonNormal.png"));
        pressedIcon = ImageIO.read(new File("src/main/java/com/ilu4/jeuxpirate/boundary/ressources/ButtonPressed.png"));
    }
}
