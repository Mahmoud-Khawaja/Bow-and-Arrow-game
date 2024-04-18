package com.game.level;

import com.game.objects.Arrow;
import com.game.player.Archer;
import processing.core.PApplet;
import com.game.objects.Balloon;
import com.game.objects.RedBalloon;
import com.game.objects.YellowBalloon;
import java.util.ArrayList;

/**
 * Represents the second level of the game.
 */
public class LevelTwo extends Level {
    private final float balloonSpacing = 30; // Spacing between balloons

    /**
     * Constructs a new LevelTwo with the specified parameters.
     * @param parent The PApplet object for drawing.
     * @param numArrows The number of arrows available in this level.
     * @param archer The player character represented by an Archer.
     */
    public LevelTwo(PApplet parent, int numArrows, Archer archer) {
        super(parent, numArrows, archer);
        createBalloons();
        createArrows();
    }

    /**
     * Creates the balloons for this level.
     */
    private void createBalloons() {
        createRedBalloons();
        createYellowBalloons();
    }

    /**
     * Creates the red balloons for this level.
     */
    private void createRedBalloons() {
        int numRedBalloons = 15;
        for (int i = 0; i < numRedBalloons; i++) {
            float balloonY = parent.random(20, parent.height - 20);
            balloons.add(new RedBalloon(parent.width - 20 - i * (balloonSpacing + 2), balloonY, 2, parent.color(255, 0, 0), parent));
        }
    }

    /**
     * Creates the yellow balloons for this level.
     */
    private void createYellowBalloons() {
        int numYellowBalloons = 3;
        for (int i = 0; i < numYellowBalloons; i++) {
            float balloonY = parent.random(20, parent.height - 20);
            float speed = parent.random(1, 3);
            float acceleration = parent.random(0.01f, 0.03f);
            balloons.add(new YellowBalloon(parent.width - 20 - i * (balloonSpacing + 2), balloonY, speed, acceleration, parent.color(255, 255, 0), parent));
        }
    }

    /**
     * Creates the arrows for this level.
     */
    private void createArrows() {
        for (int i = 0; i < numArrows; i++) {
            arrows.add(new Arrow(archer.getX(), archer.getY(), parent));
        }
    }

    /**
     * Updates the balloons and arrows in this level.
     */
    @Override
    public void update() {
        for (Balloon balloon : balloons) {
            balloon.update();
        }
        for (Arrow arrow : arrows) {
            arrow.update(balloons);
        }
    }

    /**
     * Displays the balloons and arrows in this level.
     */
    @Override
    public void display() {
        for (Balloon balloon : balloons) {
            balloon.display();
        }
        for (Arrow arrow : arrows) {
            arrow.display();
        }
    }

    /**
     * Checks if this level is completed.
     * @return True if all balloons are popped, false otherwise.
     */
    @Override
    public boolean isCompleted() {
        return balloons.isEmpty();
    }

    /**
     * Retrieves the list of balloons in this level.
     * @return The list of balloons.
     */
    @Override
    public ArrayList<Balloon> getBalloons() {
        return balloons;
    }

    /**
     * Retrieves the list of arrows in this level.
     * @return The list of arrows.
     */
    @Override
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }
}
