import com.game.level.Manager;
import processing.core.PApplet;

/**
 * Main class to start the Bow and Arrow game.
 */
public class Main extends PApplet {
    Manager manager;

    /**
     * Sets the size of the window.
     */
    public void settings() {
        size(800, 600);
    }

    /**
     * Initializes the game manager.
     */
    public void setup() {
        manager = new Manager(this);
    }

    /**
     * Draws the game elements on the screen.
     */
    public void draw() {
        background(255);
        manager.update();
        manager.display();
    }

    /**
     * Handles mouse press events.
     */
    public void mousePressed() {
        manager.mousePressed();
    }

    /**
     * Handles mouse drag events.
     */
    public void mouseDragged() {
        manager.mouseDragged();
    }

    /**
     * Main method to launch the game.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String[] processingArgs = { "Bow and Arrow" };
        PApplet.runSketch(processingArgs, new Main());
    }
}
