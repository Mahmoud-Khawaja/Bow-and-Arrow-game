package com.game.objects;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

/**
 * Represents an arrow in the our game.
 * Arrows have positions, velocities, and can collide with balloons.
 */
public class Arrow {

    /**
     * The x-coordinate of the arrow's position.
     */
    float x;

    /**
     * The y-coordinate of the arrow's position.
     */
    float y;

    /**
     * The constant speed of the arrow.
     */
    final float speed = 3;

    /**
     * The processing PApplet object for drawing.
     */
    final PApplet parent;

    /**
     * The image of the arrow.
     */
    final PImage arrowImage;

    /**
     * Constructs a new arrow with the specified parameters.
     * @param x The x-coordinate of the arrow's position.
     * @param y The y-coordinate of the arrow's position.
     * @param parent The PApplet object for drawing.
     */
    public Arrow(float x, float y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.arrowImage = parent.loadImage("src/com/game/spirits/arrow.png"); 
    }

    /**
     * Updates the arrow's position and checks for collisions with balloons.
     * @param balloons The list of balloons in the game.
     */
    public void update(ArrayList<Balloon> balloons) {
        x += speed;

        for (int i = balloons.size() - 1; i >= 0; i--) {
            Balloon balloon = balloons.get(i);
            if (hits(balloon)) {
                balloons.remove(i);
            }
        }
    }

    /**
     * Displays the arrow on the screen.
     */
    public void display() {
        parent.image(arrowImage, x, y, 50, 5);
    }

    /**
     * Checks if the arrow is offscreen.
     * @return True if the arrow is offscreen, false otherwise.
     */
    public boolean isOffscreen() {
        return x > parent.width;
    }

    /**
     * Checks if the arrow hits the specified balloon.
     * @param balloon The balloon to check collision with.
     * @return True if the arrow hits the balloon, false otherwise.
     */
    public boolean hits(Balloon balloon) {
        // Check if arrow hits the balloon
        float distance = PApplet.dist(x, y, balloon.x, balloon.y);
        return distance < 15; // Adjust this value for hit detection
    }

    /**
     * Gets the y-coordinate of the arrow's position.
     * @return The y-coordinate of the arrow.
     */
    public float getY(){
        return y;
    }

    /**
     * Gets the x-coordinate of the arrow's position.
     * @return The x-coordinate of the arrow.
     */
    public float getX(){
        return x;
    }
}
