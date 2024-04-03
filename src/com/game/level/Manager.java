package com.game.level;

import com.game.player.Archer;
import processing.core.PApplet;

public class Manager {
    private final PApplet parent;
    private final Archer archer;
    private final Level[] levels;
    private int currentLevelIndex;
    private int score;
    private int arrowsFired;

    // Main configurations
    public Manager(PApplet parent) {
        this.parent = parent;
        this.archer = new Archer(25, parent.height / 2f, parent);
        this.levels = new Level[]{new LevelOne(parent, 20, archer), new LevelTwo(parent, 20, archer)};
        this.arrowsFired = 0;
        this.score = 0;
        this.currentLevelIndex = 0;
    }

    public void update() {
        levels[currentLevelIndex].update();
        checkLevelCompletion();
    }

    public void display() {
        levels[currentLevelIndex].display();
        archer.display(parent);
        displayScore();
    }

    private void checkLevelCompletion() {
        int remainingArrows = levels[currentLevelIndex].getArrows().size() - arrowsFired;

        if (remainingArrows <= 0) {
            gameOver();
            return;
        }

        if (levels[currentLevelIndex].isCompleted()) {
            int balloonsHit = 20 - remainingArrows;
            score += (remainingArrows + 1) * balloonsHit;

            arrowsFired = 0; // Reset arrowsFired count

            currentLevelIndex++;
            if (currentLevelIndex >= levels.length) {
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
        if (!levels[currentLevelIndex].isCompleted() && !levels[currentLevelIndex].getArrows().isEmpty()) {
            if (parent.mouseButton == PApplet.LEFT) {
                fireArrow(); // Call the fireArrow method
            }
        }
    }

    private void fireArrow() {
        if (levels[currentLevelIndex].getArrows().size() > arrowsFired) {
            levels[currentLevelIndex].fireArrow();
            arrowsFired++;
        }
    }


    private void displayScore() {
        parent.fill(0);
        parent.textSize(20);
        parent.textAlign(PApplet.LEFT, PApplet.TOP);

        int remainingArrows = levels[currentLevelIndex].getArrows().size() - arrowsFired;
        int balloonsHit = 20 - remainingArrows;

        int currentScore = (remainingArrows + 1) * balloonsHit;

        parent.text("Score: " + score, 10, 10);
        parent.text("Remaining Arrows: " + remainingArrows, 10, 40);
        parent.text("Current Score: " + currentScore, 10, 70);
    }

    public void mouseDragged() {
        archer.mouseDragged(parent);
    }
}
