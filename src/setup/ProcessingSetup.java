package setup;

import TP1.GameofLife;
//import dla.DLA;
import TP2.aa.*;
import TP2.fractals.ForestApp;
import TP2.fractals.LSystemApp;
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
        // TP1
        //app = new GameofLife();        // Jogo da vida
        //app = new DLA();               // DLA

        // Physics
        //app = new ControlGUIApp();       // Controlo de corpo segundo posição, velocidade e força
        //app = new SolarSystemApp();    // Sistema solar
        //app = new ParticleSystemApp(); // Sistema de partículas
        //app = new FallingBodyApp();    // Queda livre

        // Agentes autónomos e Vida Artificial
        //app = new BoidApp();           // Boid individual
        //app = new FlockTestApp();      // Flock de boids
        //app = new ReynoldsTestApp();   // Behaviors segundo Reynolds

        // Fractal
        //app = new LSystemApp();          // Árvore
        //app = new ForestApp();         // Floresta

        //TP2
        //app = new ComportamentosIndividuaisApp();
        //app = new ComportamentosDeGrupoApp();

        PApplet.main(ProcessingSetup.class);
    }

}
