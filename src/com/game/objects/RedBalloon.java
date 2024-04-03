package com.game.objects;

import processing.core.PApplet;

public class RedBalloon extends Balloon {

    public RedBalloon(float x, float y, float speed, int color, PApplet parent) {
        super(x, y, speed, color, parent);
    }

    @Override
    public void update() {
        // Update red balloon position
        y -= speed;
        // Wrap around if balloon goes off-screen
        if (y < 0) {
            y = parent.height;
        }
    }
}
