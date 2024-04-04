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
        y -= speed;
        speed += acceleration; // Increase speed based on acceleration
        if (y <= -20) {
            y = parent.height + 20;
        }
    }
}
