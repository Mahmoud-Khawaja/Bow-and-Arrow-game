package com.game.level;

import com.game.objects.Arrow;
import com.game.player.Archer;
import processing.core.PApplet;
import com.game.objects.Balloon;
import com.game.objects.RedBalloon;
import java.util.ArrayList;

public class LevelOne extends Level {

    public LevelOne(PApplet parent, int numArrows, Archer archer) {
        super(parent, numArrows, archer);
        createBalloons();
        createArrows();
    }

    private void createBalloons() {
        float spacing = 2; // Spacing between balloons

        // Create red balloons
        for (int i = 0; i < 15; i++) {
            balloons.add(new RedBalloon(parent.width - 20 - i * (20 + spacing), parent.height / 2f, 2, parent.color(255, 0, 0), parent));
        }
    }

    private void createArrows() {
        for (int i = 0; i < numArrows; i++) {
            arrows.add(new Arrow(archer.getX(), archer.getY(), parent));
        }
    }

    @Override
    public void update() {
        for (Balloon balloon : balloons) {
            balloon.update();
        }
        for (Arrow arrow : arrows) {
            arrow.update(balloons);
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
    public ArrayList<Balloon> getBalloons() {
        return balloons;
    }

    @Override
    public ArrayList<Arrow> getArrows() {
        return arrows;
    }

    @Override
    public boolean isCompleted() {
        return balloons.isEmpty();
    }
}
