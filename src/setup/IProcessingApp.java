package setup;

import processing.core.PApplet;

import java.awt.event.KeyEvent;

public interface IProcessingApp {

    public void setup(PApplet p);
    public void draw(PApplet p, float dt);
    public void mousePressed(PApplet p);
    public void keyPressed(PApplet p);
}
