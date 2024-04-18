package com.game.player;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents the player character, an archer, in the game.
 */
public class Archer {
    private float y;
    private final float x;
    private final PApplet parent;
    private final PImage archerImage;

    /**
     * Constructs a new Archer object with the specified parameters.
     * @param x The initial x-coordinate of the archer.
     * @param y The initial y-coordinate of the archer.
     * @param parent The PApplet object for drawing.
     */
    public Archer(float x, float y, PApplet parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
        this.archerImage = parent.loadImage("src/com/game/spirits/archer.png");
    }

    /**
     * Updates the position of the archer based on the mouse input.
     * @param mouseY The y-coordinate of the mouse.
     */
    public void update(float mouseY) {
        // Update player position
        y = PApplet.constrain(mouseY, 20, parent.height - 20); // Use parent to access the height field
    }

    /**
     * Displays the archer on the screen.
     * @param parent The PApplet object for drawing.
     */
    public void display(PApplet parent) {
        parent.imageMode(parent.CENTER);
        parent.image(archerImage, x, y, 100, 120); // Draw the image at x, y
    }

    /**
     * Returns the x-coordinate of the archer.
     * @return The x-coordinate of the archer.
     */
    public float getX(){
        return x;
    }

    /**
     * Returns the y-coordinate of the archer.
     * @return The y-coordinate of the archer.
     */
    public float getY(){
        return y;
    }

    /**
     * Updates the archer's position based on mouse drag input.
     * @param parent The PApplet object for drawing.
     */
    public void mouseDragged(PApplet parent) {
        update(parent.mouseY);
    }
}
