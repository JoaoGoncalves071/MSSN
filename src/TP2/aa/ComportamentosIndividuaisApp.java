package TP2.aa;

import TP2.physics.Body;
import TP2.tools.SubPlot;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
import setup.IProcessingApp;

import java.util.ArrayList;
import java.util.List;

public class ComportamentosIndividuaisApp implements IProcessingApp {

    private Boid wander,pursuiter;
    private PImage backgroundImg;
    private Boid b1, b2;
    private final double[] window = {-10, 10, -10, 10};
    private final float[] viewport = {0, 0, 1, 1};
    private SubPlot plt;
    private Body target;
    private List<Body> allTrackingBodies;
    private int index = 0;
    private int ix = 0;
    private float seekForce = 1f;
    private int point = 0;

    @Override
    public void setup(PApplet p) {
        backgroundImg = p.loadImage("TP2/imgs/sky.jpg");
        plt = new SubPlot(window, viewport, p.width, p.height);

        wander = new Boid(new PVector(p.random((float) window[0], (float) window[1]),
                p.random((float) window[2], (float) window[3])),
                0.5f, 0.5f, p.color(255, 0, 0), p, plt);
        wander.addBehavior(new Seek(1f));

        target = new Body(new PVector(), new PVector(), 0.2f, 0.2f, p.color(0,0,220));
        pursuiter = new Boid(new PVector(p.random((float) window[0], (float) window[1]),
                p.random((float) window[2], (float) window[3])),
                0.5f, 0.5f, p.color(0, 255, 0), p, plt);
        pursuiter.addBehavior(new Pursuit(1f));
        pursuiter.addBehavior(new Flee(1f));
        pursuiter.addBehavior(new Wander(1f));
        List<Body> allTrackingBodies = new ArrayList<Body>();
        List<Body> allTrackingBodies2 = new ArrayList<Body>();
        allTrackingBodies.add(target);
        allTrackingBodies2.add(pursuiter);
        pursuiter.setEye(new Eye(pursuiter, allTrackingBodies));
        wander.setEye(new Eye(wander, allTrackingBodies2));

        // Instruções
        System.out.println("INSTRUÇÕES");
        System.out.println("0 - Pursuit");
        System.out.println("1 - Flee");
        System.out.println("2 - Wander");
        System.out.println("i - aumentar velocidade");
        System.out.println("0 - diminuir velocidade");

    }

    @Override
    public void draw(PApplet p, float dt) {
        p.image(backgroundImg, 0, 0, 800, 600);
        //p.background(255);
        wander.applyBehaviors(dt);
        pursuiter.applyBehavior(index, dt);

        wander.display(p, plt);
        pursuiter.display(p, plt);
        target.display(p, plt);
    }

    @Override
    public void mousePressed(PApplet p) {
        double[] ww = plt.getWorldCoord(p.mouseX, p.mouseY);
        target.setPos(new PVector((float) ww[0], (float) ww[1]));
    }

    @Override
    public void keyPressed(PApplet p) {
        if(p.key == '0'){
            index = 0;
        }
        if(p.key == '1'){
            index = 1;
        }
        if(p.key == '2'){
            index = 2;
        }

        if (p.key == 'i'){
            pursuiter.dna.maxSpeed += 2f;
        }
        if (p.key == 'o' && pursuiter.dna.maxSpeed > 0.5){
            pursuiter.dna.maxSpeed += -2f;
        }

    }
}
