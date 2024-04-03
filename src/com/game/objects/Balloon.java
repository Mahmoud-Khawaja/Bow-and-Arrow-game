package com.game.objects;

import com.game.objects.Arrow;
import processing.core.PApplet;

public abstract class Balloon {
    protected float x, y;
    protected float speed;
    protected int color;
    protected PApplet parent;

    public Balloon(float x, float y, float speed, int color, PApplet parent) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
        this.parent = parent;
    }

    public abstract void update();

    public void display() {
        // Draw balloon
        parent.fill(color);
        parent.ellipse(x, y, 20, 30); // Adjust balloon size as needed
    }

    public boolean checkCollision(Arrow arrow) {
        // Check if the arrow hits this balloon
        float distance = PApplet.dist(arrow.getX(), arrow.getY(), x, y);
        return distance < 15; // Adjust this value as needed for better hit detection
    }
}