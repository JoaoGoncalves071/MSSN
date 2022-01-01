package setup;

import TP1.GameofLife;
//import dla.DLA;
import TP2.aa.BoidApp;
import TP2.physics.ControlGUIApp;
import TP2.physics.FallingBodyApp;
import TP2.physics.ParticleSystemApp;
import TP2.physics.SolarSystemApp;
import processing.core.PApplet;

public class ProcessingSetup extends PApplet {

    public static IProcessingApp app;
    private int lastUpdate;

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        app.setup(this);
        lastUpdate = millis();
    }

    @Override
    public void draw() {
        int now = millis();
        float dt = (now - lastUpdate) / 1000f;
        lastUpdate = now;
        app.draw(this, dt);
    }


    @Override
    public void mousePressed(){ app.mousePressed(this); }

    @Override
    public void keyPressed() { app.keyPressed(this);}


    public static void main(String[] args) {
        //app = new GameofLife();
        //app = new DLA();
        //app = new ControlGUIApp();
        //app = new SolarSystemApp();
        //app = new ParticleSystemApp();
        //app = new FallingBodyApp();
        app = new BoidApp();
        PApplet.main(ProcessingSetup.class);
    }

}
