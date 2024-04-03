import com.game.level.Manager;
import processing.core.PApplet;

public class Main extends PApplet {
    Manager manager;

    public void settings() {
        size(800, 600);
    }

    public void setup() {
        manager = new Manager(this);
    }

    public void draw() {
        background(255);
        manager.update();
        manager.display();
    }

    public void mousePressed() {
        manager.mousePressed();
    }

    public void mouseDragged() {
        manager.mouseDragged();
    }

    public static void main(String[] args) {
        String[] processingArgs = { "Bow and Arrow" };
        PApplet.runSketch(processingArgs, new Main());
    }
}
