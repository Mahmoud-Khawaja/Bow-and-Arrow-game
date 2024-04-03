package com.game.level;

import com.game.objects.Arrow;
import com.game.player.Archer;
import processing.core.PApplet;
import com.game.objects.Balloon;
import com.game.objects.RedBalloon;
import com.game.objects.YellowBalloon;
import java.util.ArrayList;

public class LevelTwo extends Level {
    private final float balloonSpacing = 30; // Spacing between balloons

    public LevelTwo(PApplet parent, int numArrows, Archer archer) {
        super(parent, numArrows, archer);
        createBalloons();
        createArrows();
    }

    private void createBalloons() {
        createRedBalloons();
        createYellowBalloons();
    }

    private void createRedBalloons() {
        // Number of red balloons for Level Two
        int numRedBalloons = 15;
        for (int i = 0; i < numRedBalloons; i++) {
            float balloonY = parent.random(20, parent.height - 20); // Random Y-coordinate within the screen boundaries
            balloons.add(new RedBalloon(parent.width - 20 - i * (balloonSpacing + 2), balloonY, 2, parent.color(255, 0, 0), parent));
        }
    }

    private void createYellowBalloons() {
        // Number of yellow balloons for Level Two
        int numYellowBalloons = 3;
        for (int i = 0; i < numYellowBalloons; i++) {
            float balloonY = parent.random(20, parent.height - 20); // Random Y-coordinate within the screen boundaries
            float speed = parent.random(1, 3); // Random speed between 1 and 3
            float acceleration = parent.random(0.01f, 0.03f); // Random acceleration between 0.01 and 0.05
            balloons.add(new YellowBalloon(parent.width - 20 - i * (balloonSpacing + 2), balloonY, speed, acceleration, parent.color(255, 255, 0), parent));
        }
    }

    private void createArrows() {
        for (int i = 0; i < numArrows; i++) {
            arrows.add(new Arrow(archer.getX(), archer.getY(), parent));
        }
    }

    @Override
    public void update() {
        // Update balloon positions
        for (Balloon balloon : balloons) {
            balloon.update();
        }
        // Update arrow positions
        for (Arrow arrow : arrows) {
            arrow.update(balloons); // Pass the list of balloons to the arrow's update method
        }
    }

    @Override
    public void display() {
        for (Balloon balloon : balloons) {
            balloon.display();
        }
        for (Arrow arrow : arrows) {
            arrow.display();
        }
    }

    @Override
    public boolean isCompleted() {
        return balloons.isEmpty();
    }

    @Override
    public ArrayList<Balloon> getBalloons() {
        return balloons;
    }

    @Override
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }
}
