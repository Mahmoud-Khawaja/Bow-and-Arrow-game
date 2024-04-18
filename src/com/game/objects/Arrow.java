package com.game.objects;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Arrow {
    float x, y;
    final float speed = 3;
    final PApplet parent;
    final PImage arrowImage; 

    public Arrow(float x, float y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.arrowImage = parent.loadImage("src/com/game/spirits/arrow.png"); 
    }

    public void update(ArrayList<Balloon> balloons) {
        x += speed;

        for (int i = balloons.size() - 1; i >= 0; i--) {
            Balloon balloon = balloons.get(i);
            if (hits(balloon)) {
                balloons.remove(i);
            }
        }
    }

    public void display() {
        parent.image(arrowImage, x, y, 50, 5);
    }

    public boolean isOffscreen() {
        return x > parent.width;
    }

    public boolean hits(Balloon balloon) {
        // Check if arrow hits the balloon
        float distance = PApplet.dist(x, y, balloon.x, balloon.y);
        return distance < 15; 
    }

    public float getY(){
        return y;
    }
    public float getX(){
        return x;
    }
}
