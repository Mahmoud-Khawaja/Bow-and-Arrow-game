package com.game.level;

import com.game.objects.Arrow;
import com.game.player.Archer;
import processing.core.PApplet;
import com.game.objects.Balloon;

import java.util.ArrayList;

/**
 * Represents a level in the Bow and Arrow game.
 * Each level consists of a set number of arrows, balloons, and an archer.
 */
public abstract class Level {
    
    /**
     * The processing PApplet object for drawing.
     */
    protected PApplet parent;

    /**
     * The number of arrows available in this level.
     */
    protected int numArrows;

    /**
     * List of balloons for this level.
     */
    protected ArrayList<Balloon> balloons;

    /**
     * List of arrows fired by the player.
     */
    protected ArrayList<Arrow> arrows;

    /**
     * The player's character, the archer.
     */
    protected Archer archer;

    /**
     * Constructs a new level with the specified parameters.
     * @param parent The PApplet object for drawing.
     * @param numArrows The initial number of arrows available.
     * @param archer The player's archer character.
     */
    public Level(PApplet parent, int numArrows, Archer archer) {
        this.parent = parent;
        this.numArrows = numArrows;
        this.archer = archer;
        balloons = new ArrayList<>();
        arrows = new ArrayList<>();
    }

    /**
     * Updates the level state, including arrow movement and balloon collisions.
     */
    public void update() {
        // Update arrow positions
        for (Arrow arrow : arrows) {
            arrow.update(balloons);
        }
    }

    /**
     * Displays the level elements, including balloons and arrows.
     */
    public abstract void display();

    /**
     * Gets the list of balloons in this level.
     * @return The list of balloons.
     */
    public abstract ArrayList<Balloon> getBalloons();

    /**
     * Gets the list of arrows fired in this level.
     * @return The list of arrows.
     */
    public abstract ArrayList<Arrow> getArrows();

    /**
     * Checks if the level completion condition is met.
     * @return True if the level is completed, false otherwise.
     */
    public abstract boolean isCompleted();

    /**
     * Fires an arrow from the archer's position.
     * Decreases the number of available arrows.
     */
    public void fireArrow() {
        if (numArrows > 0) {
            Arrow arrow = new Arrow(archer.getX(), archer.getY(), parent);
            arrows.add(arrow);
            numArrows--;
        }
    }
}
