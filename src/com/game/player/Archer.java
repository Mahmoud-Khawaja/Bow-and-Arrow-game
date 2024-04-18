package com.game.player;

import processing.core.PApplet;
import processing.core.PImage;

public class Archer {
    private float y;
    private final float x;
    private final PApplet parent;
    private final PImage archerImage;

    public Archer(float x, float y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.archerImage = parent.loadImage("src/com/game/spirits/archer.png");
    }

    public void update(float mouseY) {
        // Update player position
        y = PApplet.constrain(mouseY, 20, parent.height - 20); // Use parent to access the height field
    }

    public void display(PApplet parent) {
        parent.imageMode(parent.CENTER);
        parent.image(archerImage, x, y,100,120); // Draw the image at x, y
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void mouseDragged(PApplet parent) {
        update(parent.mouseY);
    }
}
