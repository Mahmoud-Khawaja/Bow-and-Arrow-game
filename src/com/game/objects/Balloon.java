package com.game.objects;

import processing.core.PApplet;

/**
 * Represents a balloon in the our game.
 * Balloons have positions, colors, and can move vertically.
 */
public abstract class Balloon {
    
    /**
     * The x-coordinate of the balloon's position.
     */
    protected float x;

    /**
     * The y-coordinate of the balloon's position.
     */
    protected float y;

    /**
     * The vertical speed of the balloon.
     */
    protected float speed;

    /**
     * The color of the balloon.
     */
    protected int color;

    /**
     * The processing PApplet object for drawing.
     */
    protected PApplet parent;

    /**
     * Constructs a new balloon with the specified parameters.
     * @param x The x-coordinate of the balloon's position.
     * @param y The y-coordinate of the balloon's position.
     * @param speed The vertical speed of the balloon.
     * @param color The color of the balloon.
     * @param parent The PApplet object for drawing.
     */
    public Balloon(float x, float y, float speed, int color, PApplet parent) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color = color;
        this.parent = parent;
    }

    /**
     * Updates the balloon's position or state.
     */
    public abstract void update();

    /**
     * Displays the balloon on the screen.
     */
    public void display() {
        // Draw balloon
        parent.fill(color);
        parent.ellipse(x, y, 20, 30); // Adjust balloon size as needed
    }

    /**
     * Checks if the balloon collides with the specified arrow.
     * @param arrow The arrow to check collision with.
     * @return True if the balloon collides with the arrow, false otherwise.
     */
    public boolean checkCollision(Arrow arrow) {
        float distance = PApplet.dist(arrow.getX(), arrow.getY(), x, y);
        return distance < 15; // Adjust this value for hit detection
    }
}