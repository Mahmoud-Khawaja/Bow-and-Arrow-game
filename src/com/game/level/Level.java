    package com.game.level;

    import com.game.objects.Arrow;
    import com.game.player.Archer;
    import processing.core.PApplet;
    import com.game.objects.Balloon;

    import java.util.ArrayList;

    public abstract class Level {
        protected PApplet parent;
        protected int numArrows;
        protected ArrayList<Balloon> balloons; // List of balloons for this level
        protected ArrayList<Arrow> arrows;
        protected Archer archer;

        public Level(PApplet parent, int numArrows, Archer archer) {
            this.parent = parent;
            this.numArrows = numArrows;
            this.archer = archer;
            balloons = new ArrayList<>();
            arrows = new ArrayList<>();
        }

        public void update() {
            // Update arrow positions
            for (Arrow arrow : arrows) {
                arrow.update(balloons);
            }

        }

        public abstract void display();
        public abstract ArrayList<Balloon> getBalloons();
        public abstract ArrayList<Arrow> getArrows();
        public abstract boolean isCompleted();

        // Method to fire an arrow from the archer's position
        public void fireArrow() {
            if (numArrows > 0) {
                Arrow arrow = new Arrow(archer.getX(), archer.getY(), parent);
                arrows.add(arrow);
                numArrows--;
            }
        }
    }
