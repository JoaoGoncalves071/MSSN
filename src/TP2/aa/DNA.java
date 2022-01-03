package TP2.aa;

public class DNA {

    //Physics
    public float maxSpeed;
    public float maxForce;
    // Vision
    public float visionDistance;
    public float visionSafeDistance;
    public float visionAngle;
    // Pursuit
    public float deltaTPursuit;
    // Arrive
    public float radiusArrive;
    // Wander
    public float deltaTWander;
    public float radiusWander;
    public float deltaPhiWander;

    public DNA(){
        // Physics
        maxSpeed = random(3, 5);
        maxForce = random(4, 7);
        // Vision
        visionDistance     = random(2, 2);
        visionSafeDistance = 0.25f * visionDistance;
        visionAngle        = (float) Math.PI * 0.8f;
        // Pursuit
        deltaTPursuit = random(0.5f, 1f);
        // Arrive
        radiusArrive = random(3, 5);
        // Wander
        deltaTWander   = random(0.5f, 0.7f);
        radiusWander   = random(2, 4);
        deltaPhiWander = (float) Math.PI/8;
    }

    public static float random(float min, float max){
        return (float) (min + (max - min) * Math.random());
    }

}
