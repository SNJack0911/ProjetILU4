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

/**
 *
 * @author yannf
 */
public class JPirateIcon extends JPanelWithBackground{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomPirate;
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        
        if(nomPirate != null){
            g2d.setColor(Color.BLACK);
            int fontSize = 14;
                
            Font titleFont = new Font("Segoe UI", Font.PLAIN, fontSize);
            g2d.setFont(titleFont);
            FontMetrics fm = g2d.getFontMetrics();
            
            int nameWidth = fm.stringWidth(nomPirate);
            int x = (getWidth() - nameWidth)/2;
            
            int y = getHeight() - fontSize + 8;
            g2d.drawString(nomPirate, x, y);
        }
    }
    
    public void setNomPirate(String nomPirate){
        this.nomPirate = nomPirate;
    }
}
