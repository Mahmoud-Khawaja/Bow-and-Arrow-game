// Arrow.java
package com.game.objects;

import processing.core.PApplet;

import java.util.ArrayList;

public class Arrow {
    float x, y;
    float speed = 3; // Adjust arrow speed as needed
    PApplet parent;

    public Arrow(float x, float y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public void update(ArrayList<Balloon> balloons) {
        // Update arrow position if fired
        x += speed;

        // Check for collision with balloons
        for (int i = balloons.size() - 1; i >= 0; i--) {
            Balloon balloon = balloons.get(i);
            if (hits(balloon)) {
                balloons.remove(i); // Remove the balloon from the list
            }
        }
    }

    public void display() {
        // Draw arrow
        parent.stroke(0);
        parent.line(x, y, x + 20, y); // Adjust arrow length as needed
    }

    public boolean isOffscreen() {
        // Check if arrow is offscreen
        return x > parent.width;
    }

    public boolean hits(Balloon balloon) {
        // Check if arrow hits the balloon
        float distance = PApplet.dist(x, y, balloon.x, balloon.y);
        return distance < 15; // Adjust this value as needed for better hit detection
    }

    public float getY(){
        return y;
    }
    public float getX(){
        return x;
    }

}

