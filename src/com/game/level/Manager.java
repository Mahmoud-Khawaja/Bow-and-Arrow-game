package com.game.level;

import com.game.player.Archer;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private final PApplet parent;
    private final Archer archer;
    private final ArrayList<Level> levels;
    private final HashMap<Level, Integer> balloonsInLevel;
    private final int arrowsNumber;
    private int currentLevelIndex;
    private int score;
    private int arrowsFired;

    // Main configurations
    public Manager(PApplet parent) {
        this.parent = parent;
        this.archer = new Archer(25, parent.height / 2f, parent);
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

    public void update() {
        levels.get(currentLevelIndex).update();
        checkLevelCompletion();
    }

    public void display() {
        levels.get(currentLevelIndex).display();
        archer.display(parent);
        displayScore();
    }

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
            arrowsFired = 0; // Reset arrowsFired count
            currentLevelIndex++;

            if (currentLevelIndex >= levels.size()) {
                gameOver();
            }
        }
    }

    private void gameOver() {
        parent.textSize(32);
        parent.fill(255, 0, 0);
        parent.textAlign(PApplet.CENTER, PApplet.CENTER);
        parent.text("Game Over", parent.width / 2f, parent.height / 2f);
        parent.noLoop();
    }

    public void mousePressed() {
        Level currentLevel = levels.get(currentLevelIndex);
        if (!currentLevel.isCompleted() && !currentLevel.getArrows().isEmpty()) {
            if (parent.mouseButton == PApplet.LEFT) {
                fireArrow();
                currentLevel.getArrows().removeFirst(); // Remove the first arrow
            }
        }
    }

    private void fireArrow() {
        Level currentLevel = levels.get(currentLevelIndex);
        if (currentLevel.getArrows().size() > arrowsFired) {
            currentLevel.fireArrow();
            arrowsFired++;
        }
    }

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


    public void mouseDragged() {
        archer.mouseDragged(parent);
    }
}
