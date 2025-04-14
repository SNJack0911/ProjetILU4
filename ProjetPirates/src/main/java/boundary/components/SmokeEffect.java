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
    public int x, y;
    public Image image;
    public long creationTime;

    public SmokeEffect(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.creationTime = System.currentTimeMillis();
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - creationTime > 1000; // 1s
    }
}

