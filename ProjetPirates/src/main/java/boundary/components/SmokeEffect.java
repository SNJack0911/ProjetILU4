package boundary.components;

import java.awt.Image;

/**
 *
 * @author leo et yannf
 */

public class SmokeEffect {
    public Image image;
    public int x, y;
    public float alpha = 1.0f;
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
    }
}