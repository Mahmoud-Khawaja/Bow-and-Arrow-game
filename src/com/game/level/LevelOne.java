package com.game.level;

import com.game.objects.Arrow;
import com.game.player.Archer;
import processing.core.PApplet;
import com.game.objects.Balloon;
import com.game.objects.RedBalloon;
import java.util.ArrayList;

/**
 * Represents the first level of the game.
 */
public class LevelOne extends Level {

    /**
     * Constructs a new LevelOne with the specified parameters.
     * @param parent The PApplet object for drawing.
     * @param numArrows The number of arrows available in this level.
     * @param archer The player character represented by an Archer.
     */
    public LevelOne(PApplet parent, int numArrows, Archer archer) {
        super(parent, numArrows, archer);
        createBalloons();
        createArrows();
    }

    /**
     * Creates the balloons for this level.
     */
    private void createBalloons() {
        float spacing = 2; // Spacing between balloons

        // Create red balloons
        for (int i = 0; i < 15; i++) {
            balloons.add(new RedBalloon(parent.width - 20 - i * (20 + spacing), parent.height / 2f, 2, parent.color(255, 0, 0), parent));
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

    /**
     * Checks if this level is completed.
     * @return True if all balloons are popped, false otherwise.
     */
    @Override
    public boolean isCompleted() {
        return balloons.isEmpty();
    }
}
