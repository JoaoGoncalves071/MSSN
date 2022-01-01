package TP2.aa;

import TP2.physics.Body;
import TP2.tools.SubPlot;
import processing.core.PApplet;
import processing.core.PVector;
import setup.IProcessingApp;

import java.util.ArrayList;
import java.util.List;

public class BoidApp implements IProcessingApp {

    private Boid b;
    private double[] window = {-10, 10, -10, 10};
    private float[] viewport = {0, 0, 1, 1};
    private SubPlot plt;
    private Body target;
    private List<Body> allTrackingBodies;

    @Override
    public void setup(PApplet p) {
        plt = new SubPlot(window, viewport, p.width, p.height);
        b = new Boid(new PVector(), new PVector(), 1, 0.5f, p.color(0), p, plt);
        b.addBehavior(new Seek(1f));
        target = new Body(new PVector(), new PVector(), 1f, 0.3f, p.color(255, 0, 0));
        allTrackingBodies = new ArrayList<Body>();
        allTrackingBodies.add(target);
        Eye eye = new Eye(b, allTrackingBodies);
        b.setEye(eye);
    }

    @Override
    public void draw(PApplet p, float dt) {
        p.background(255);

        b.applyBehaviors(dt);

        b.display(p, plt);
    }

    @Override
    public void mousePressed(PApplet p) {
        double[] ww = plt.getWorldCoord(p.mouseX, p.mouseY);
        target.setPos(new PVector((float) ww[0], (float) ww[1]));
    }

    @Override
    public void keyPressed(PApplet p) {

    }
}
