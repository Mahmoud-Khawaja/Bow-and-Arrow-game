package com.game.objects;

import processing.core.PApplet;

/**
 * Represents a red balloon in the game.
 */
public class RedBalloon extends Balloon {

    /**
     * Constructs a new RedBalloon with the specified parameters.
     * @param x The x-coordinate of the balloon.
     * @param y The y-coordinate of the balloon.
     * @param speed The speed of the balloon.
     * @param color The color of the balloon.
     * @param parent The PApplet object for drawing.
     */
    public RedBalloon(float x, float y, float speed, int color, PApplet parent) {
        super(x, y, speed, color, parent);
    }

    /**
     * Updates the position of the balloon.
     */
    @Override
    public void update() {
        y -= speed;
        // Wrap around if balloon goes off-screen
        if (y <= -20) { // 20 is the height of the balloon this is better than y<=0 for smoothness
            y = parent.height + 20;
        }
    }
}

