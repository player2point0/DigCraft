import peasy.*;

import processing.core.PApplet;

public class test extends PApplet
{
    PeasyCam cam;

    public void settings()
    {
        size(1000, 1000, "processing.opengl.PGraphics3D");
    }

    public void setup()
    {
        cam = new PeasyCam(this, 100);
        cam.setMinimumDistance(50);
        cam.setMaximumDistance(500);


        rotateX(-.5f);
        rotateY(-.5f);
        fill(255,0,0);

        pushMatrix();
        translate(0,0,20);
        fill(0,0,255);
        box(5);
        popMatrix();
    }

    public void draw()
    {
        background(0);
        box(30);

    }

    public static void main(String... args)
    {
        PApplet.main("test");
    }




}
