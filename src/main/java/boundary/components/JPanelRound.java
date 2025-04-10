/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author yannf
 */
public class JPanelRound extends JPanel{

    public JPanelRound(){
        super();
        setOpaque(false);
        setDoubleBuffered(true);
    }

    /*
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Color c1 = new Color(150, 110, 75, 40);
        g2d.setColor(c1);

        int width = getWidth();
        int height = getHeight();
        g2d.drawRoundRect(0, 0, width, height, width/12 ,height/12);

        int newWidth = (int) (getWidth() *0.92);
        int newHeight = (int) (getWidth() *0.92);

        Color c2 = new Color(200, 160, 125, 80);
        g2d.setColor(c2);
        g2d.drawRoundRect((width-newWidth)/2, (height-newHeight)/2, newWidth, newHeight, width/12 ,height/12);
    }*/

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Enable anti-aliasing for smooth rendering
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        setOpaque(false); // Make panel transparent

        int width = getWidth();
        int height = getHeight();

        // === SHADOW ===
        int shadowOffset = 5;
        Color shadowColor = new Color(0, 0, 0, 30);
        g2d.setColor(shadowColor);
        g2d.fillRoundRect(shadowOffset, shadowOffset, width - shadowOffset, height - shadowOffset, width/12, height/12);

        // === MAIN PANEL BACKGROUND ===
        Color c1 = new Color(50, 30, 10, 220);
        Color c2 = new Color(200, 160, 125, 25);
        Color c3 = new Color(220, 185, 135, 220);
        g2d.setColor(c3);
        g2d.fillRoundRect(0, 0, width - shadowOffset, height - shadowOffset, width/12, height/12);

        // === INNER ROUNDED RECT ===
        int innerPadding = 1;
        int newWidth = width - shadowOffset - innerPadding * 2;
        int newHeight = height - shadowOffset - innerPadding * 2;
        g2d.setColor(c2);
        g2d.fillRoundRect(innerPadding, innerPadding, newWidth, newHeight, width/12, height/12);



        // === TITLE LOZENGE ===
        String title = "Options";
        Font titleFont = new Font("Windlass", Font.PLAIN, 16);
        g2d.setFont(titleFont);
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(title);
        int textHeight = fm.getHeight();

        int lozengePaddingX = 20;
        int lozengePaddingY = 5;
        int lozengeWidth = textWidth + lozengePaddingX * 2;
        int lozengeHeight = textHeight + lozengePaddingY * 2;
        int lozengeX = (width - lozengeWidth) / 2;
        int lozengeY = 10;

        // Lozenge background
        g2d.setColor(c2);
        g2d.fillRoundRect(lozengeX, lozengeY, lozengeWidth, lozengeHeight, 30, 30);

        // Lozenge border
        g2d.setColor(c1);
        g2d.drawRoundRect(lozengeX, lozengeY, lozengeWidth, lozengeHeight, 30, 30);

        // Draw title text
        g2d.setColor(c1);
        int textX = lozengeX + lozengePaddingX;
        int textY = lozengeY + fm.getAscent() + lozengePaddingY;
        g2d.drawString(title, textX, textY);

        g2d.dispose();
    }

}
