package com.game.objects;

import processing.core.PApplet;

public class RedBalloon extends Balloon {

    public RedBalloon(float x, float y, float speed, int color, PApplet parent) {
        super(x, y, speed, color, parent);
    }

    @Override
    public void update() {
        y -= speed;
        // Wrap around if balloon goes off-screen
        if (y <= -20) { // 20 is the height of the balloon this is better than y<=0 for smoothness
            y = parent.height + 20;
        }
    }
}
