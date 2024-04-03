package com.game.objects;

import processing.core.PApplet;

public class YellowBalloon extends Balloon {
    private float acceleration;

    public YellowBalloon(float x, float y, float speed, float acceleration, int color, PApplet parent) {
        super(x, y, speed, color, parent);
        this.acceleration = acceleration;
    }

    @Override
    public void update() {
        // Update yellow balloon position
        y -= speed; // Remove the multiplication by 2 since yellow balloons move at regular speed
        speed += acceleration; // Increase speed based on acceleration
        // Wrap around if balloon goes off-screen
        if (y < 0) {
            y = parent.height;
        }
    }
}
