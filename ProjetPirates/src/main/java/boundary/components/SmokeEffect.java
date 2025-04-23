package boundary.components;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.*;

public class SmokeEffect {
    public Image image;
    public int x, y;
    public float alpha = 1.0f;
    private int size = 60;

    public SmokeEffect(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void diminuerAlpha(float valeur) {
        alpha = Math.max(0f, alpha - valeur);
    }

    public boolean estTerminee() {
        return alpha <= 0f;
    }

    public void setSize(int size) {
        this.size = size;
    }
    /*
    public void dessiner(Graphics2D g2) {
        Composite original = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.drawImage(image, x, y, size, size, null);
        g2.setComposite(original);
    }
    */
}






/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * 
package boundary.components;

import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author choue
 *
public class SmokeEffect {
    public Image image;
    public int x, y;
    public float alpha;

    public SmokeEffect(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.alpha = 1.0f;
    }

    public void diminuerAlpha(float valeur) {
        alpha = Math.max(0f, alpha - valeur);
    }

    public boolean estTerminee() {
        return alpha <= 0f;
    }
private int size = 80; // taille par défaut
//f.setSize(100 + new Random().nextInt(20)); // variation pour un effet organique


public void setSize(int size) {
    this.size = size;
}

public void dessiner(Graphics2D g2) {
    Composite original = g2.getComposite();
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    g2.drawImage(image, x, y, size, size, null);
    g2.setComposite(original);
}


} */
