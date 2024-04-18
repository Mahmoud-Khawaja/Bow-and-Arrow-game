package com.game.level;

import com.game.player.Archer;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages the overall gameplay including levels, score, and player actions.
 */
public class Manager {

    /**
     * The processing PApplet object for drawing.
     */
    private final PApplet parent;

    /**
     * The player character represented by an Archer.
     */
    private final Archer archer;

    /**
     * The list of levels in the game.
     */
    private final ArrayList<Level> levels;

    /**
     * Mapping of levels to the initial number of balloons.
     */
    private final HashMap<Level, Integer> balloonsInLevel;

    /**
     * The total number of arrows available to the player.
     */
    private final int arrowsNumber;

    /**
     * The index of the current level being played.
     */
    private int currentLevelIndex;

    /**
     * The player's score.
     */
    private int score;

    /**
     * The number of arrows fired by the player.
     */
    private int arrowsFired;

    /**
     * Constructs a new Manager with the specified parameters.
     * @param parent The PApplet object for drawing.
     */
    public Manager(PApplet parent) {
        this.parent = parent;
        this.archer = new Archer(50, parent.height / 2f, parent);
        this.arrowsNumber = 20;
        this.arrowsFired = 0;
        this.score = 0;
        this.currentLevelIndex = 0;

        // Initialize levels
        this.levels = new ArrayList<>();
        this.levels.add(new LevelOne(parent, arrowsNumber, archer));
        this.levels.add(new LevelTwo(parent, arrowsNumber, archer));

        // Getting Balloons in each level
        this.balloonsInLevel = new HashMap<>();
        for (Level level : levels) {
            balloonsInLevel.put(level, level.getBalloons().size());
        }
    }

    /**
     * Updates the current level and checks for level completion.
     */
    public void update() {
        levels.get(currentLevelIndex).update();
        checkLevelCompletion();
    }

    /**
     * Displays the current level, player, and score on the screen.
     */
    public void display() {
        parent.background(0, 255, 0); // Set background color to green
        levels.get(currentLevelIndex).display();
        archer.display(parent);
        displayScore();
        if(!parent.isLooping())gameOver();
    }

    /**
     * Checks if the current level is completed and handles level transitions.
     */
    private void checkLevelCompletion() {
        Level currentLevel = levels.get(currentLevelIndex);
        int remainingArrows = currentLevel.getArrows().size() - arrowsFired;
    
        if (remainingArrows <= 0) {
            gameOver();
            return;
        }
    
        if (currentLevel.isCompleted()) {
            int balloonsHit = arrowsNumber - remainingArrows;
            score += (remainingArrows + 1) * balloonsHit;
            arrowsFired = 0; 
    
            if (currentLevelIndex + 1 >= levels.size()) {
                gameOver();
            } else {
                currentLevelIndex++;
            }
        }
    }

    /**
     * Displays the "Game Over" message and stops the game loop.
     */
    private void gameOver() {
        parent.textSize(32);
        parent.fill(255, 0, 0);
        parent.textAlign(PApplet.CENTER, PApplet.CENTER);
        parent.text("Game Over", parent.width / 2f, parent.height / 2f);
        parent.noLoop();
    }

    /**
     * Handles player mouse input for firing arrows.
     */
    public void mousePressed() {
        Level currentLevel = levels.get(currentLevelIndex);
        if (!currentLevel.isCompleted() && !currentLevel.getArrows().isEmpty()) {
            if (parent.mouseButton == PApplet.LEFT) {
                fireArrow();
                currentLevel.getArrows().remove(0); // Remove the first arrow
            }
        }
    }

    /**
     * Fires an arrow from the player's position.
     */
    private void fireArrow() {
        Level currentLevel = levels.get(currentLevelIndex);
        if (currentLevel.getArrows().size() > arrowsFired) {
            currentLevel.fireArrow();
            arrowsFired++;
        }
    }

    /**
     * Displays the player's score on the screen.
     */
    private void displayScore() {
        parent.fill(0);
        parent.textSize(15);
        parent.textAlign(PApplet.LEFT, PApplet.TOP);

        Level currentLevel = levels.get(currentLevelIndex);
        int remainingArrows = arrowsNumber - arrowsFired;
        int shotBalloons = balloonsInLevel.get(currentLevel) - currentLevel.getBalloons().size();

        int currentScore = (remainingArrows + 1) * shotBalloons;

        parent.text("Score: " + score + "| Current Score: " + currentScore + " | Remaining Arrows: " + remainingArrows, 10, 10);
    }

    /**
     * Handles player mouse dragging for aiming the archer.
     */
    public void mouseDragged() {
        archer.mouseDragged(parent);
    }
}
