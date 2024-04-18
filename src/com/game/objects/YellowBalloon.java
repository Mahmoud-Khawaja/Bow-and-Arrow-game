package com.game.objects;

import processing.core.PApplet;

/**
 * Represents a yellow balloon in the game.
 */
public class YellowBalloon extends Balloon {
    private float acceleration;

    /**
     * Constructs a new YellowBalloon with the specified parameters.
     * @param x The x-coordinate of the balloon.
     * @param y The y-coordinate of the balloon.
     * @param speed The speed of the balloon.
     * @param acceleration The acceleration of the balloon.
     * @param color The color of the balloon.
     * @param parent The PApplet object for drawing.
     */
    public YellowBalloon(float x, float y, float speed, float acceleration, int color, PApplet parent) {
        super(x, y, speed, color, parent);
        this.acceleration = acceleration;
    }

    /**
     * Updates the position of the balloon and adjusts speed based on acceleration.
     */
    @Override
    public void update() {
        // Update yellow balloon position
        y -= speed;
        speed += acceleration; // Increase speed based on acceleration
        if (y <= -20) {
            y = parent.height + 20;
        }
    }
}
