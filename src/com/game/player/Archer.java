package com.game.player;

import processing.core.PApplet;

public class Archer {
    private final float x;
    private float y;
    private final PApplet parent;

    public Archer(float x, float y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public void update(float mouseY) {
        // Update player position
        y = parent.constrain(mouseY, 20, parent.height - 20); // Use parent to access the height field
    }

    public void display(PApplet parent) {
        parent.fill(0);
        parent.rectMode(parent.CENTER);
        parent.rect(x, y, 20, 40);
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
