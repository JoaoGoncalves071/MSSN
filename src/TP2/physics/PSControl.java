package TP2.physics;

import processing.core.PVector;

public class PSControl {

    // angulo
    private float averageAngle;
    private float dispersionAngle;
    // velocidade
    private float minVelocity;
    private float maxVelocity;
    // tempo de vida
    private float minLifetime;
    private float maxLifetime;
    // raio
    private float minRadius;
    private float maxRadius;
    // quantidade de particulas por segundo
    private float flow;
    // cor
    private int color;


    public PSControl(float[] velControl, float[] lifetime, float[] radius, float flow, int color){
        setVelParams(velControl);
        setLifetimeParams(lifetime);
        setRadiusParams(radius);
        setFlow(flow);
        setColor(color);
    }

    public void setVelParams (float[] velControl){
        averageAngle    = velControl[0];
        dispersionAngle = velControl[1];
        minVelocity     = velControl[2];
        maxVelocity     = velControl[3];
    }

    public void setLifetimeParams(float[] lifetime){
        minLifetime = lifetime[0];
        maxLifetime = lifetime[1];
    }

    public float getRndLifetime(){
        return getRandom(minLifetime, maxLifetime);
    }

    public void setRadiusParams(float[] radius){
        minRadius = radius[0];
        maxRadius = radius[1];
    }

    public float getRndRadius(){
        return getRandom(minRadius, maxRadius);
    }

    public void setFlow(float flow){
        this.flow = flow;
    }

    public float getFlow(){
        return flow;
    }

    public void setColor(int color){
        this.color = color;
    }

    public int getColor(){
        return color;
    }

    public PVector getRndVel(){
        float angle = getRandom(averageAngle - dispersionAngle/2, averageAngle + dispersionAngle/2);
        PVector v = PVector.fromAngle(angle);
        return v.mult(getRandom(minVelocity, maxVelocity));
    }

    public static float getRandom(float min, float max){
        return min + (float) (Math.random() * (max - min));
    }

}
