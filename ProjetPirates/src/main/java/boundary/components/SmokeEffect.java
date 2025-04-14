/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.components;

import java.awt.Image;

/**
 *
 * @author choue
 */
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
}
