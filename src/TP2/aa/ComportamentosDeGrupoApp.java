package TP2.aa;

import TP2.physics.Body;
import TP2.tools.SubPlot;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import setup.IProcessingApp;
import java.util.ArrayList;
import java.util.List;

public class ComportamentosDeGrupoApp implements IProcessingApp {

    private PImage backgroundImg;
    private Boid boid;
    private Body target;
    private Flock flock1;
    private float[] sacWeights = {1f, 1f, 1f};
    private double[] window = {-10, 10, -10, 10};
    private float[] viewport = {0, 0, 1, 1};
    private SubPlot plt;
    private List<Body> allTrackingBodies;

    @Override
    public void setup(PApplet p) {
        backgroundImg = p.loadImage("TP2/imgs/sea.jpg");
        plt = new SubPlot(window, viewport, p.width, p.height);
        flock1 = new Flock(200, 0.1f, 0.3f, p.color(0, 200, 50), sacWeights,p, plt);
        flock1.addBehavior(new Seek(1f));
        boid = flock1.getBoid(0);
        boid.setShape(p, plt, 0.3f, p.color(255, 0, 0));
        boid.removeBehavior(boid.behaviors.get(3));
        boid.removeBehavior(boid.behaviors.get(2));
        boid.removeBehavior(boid.behaviors.get(1));
        boid.removeBehavior(boid.behaviors.get(0));
        boid.addBehavior(new Seek(1f));
        target = new Body(new PVector(), new PVector(), 1f, 0.3f, p.color(255, 0, 0));
        allTrackingBodies = new ArrayList<Body>();
        allTrackingBodies.add(target);
        Eye eye = new Eye(boid, allTrackingBodies);
        boid.setEye(eye);
    }

    @Override
    public void draw(PApplet p, float dt) {
        //p.background(255);
        p.image(backgroundImg, 0, 0, 800, 600);
        float[] bb = plt.getBoundingBox();
        p.fill(255, 64);
        p.rect(bb[0], bb[1], bb[2], bb[3]);
        flock1.applyBehavior(dt);
        boid.applyBehaviors(dt);
        flock1.display(p, plt);
        target.display(p, plt);
        //boid.getEye().display(p, plt);
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
