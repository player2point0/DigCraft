
import processing.core.PApplet;

public class test extends PApplet
{

    public void settings()
    {
        size(1000, 1000, "processing.opengl.PGraphics3D");
    }

    public void setup()
    {
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
