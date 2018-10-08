/*
import processing.core.PApplet;

public class test extends PApplet
{
    int redColor;
    int blackColor;

    public void settings()
    {
        size(1000, 1000, "processing.opengl.PGraphics3D");
    }

    public void setup()
    {
        redColor = color(255,0,0,255);
        blackColor = color(0,0,0,255);

        translate(width/2, height/2, 0);   //recenter

        //camera(70.0f, 35.0f, 120.0f, 50.0f, 50.0f, 0.0f, 0.0f, 1.0f, 0.0f);


        GameObject block = new GameObject(0,200,0,100,100,100,blackColor,redColor);
        block.Render(this);


        GameObject block1 = new GameObject(100,200,100,100,100,100,blackColor,redColor);
        block1.Render(this);

        GenerateTerrain(10,10);
    }

    public void draw()
    {
    }

    public static void main(String... args)
    {
        PApplet.main("test");
    }

    public void GenerateTerrain(int xSize, int zSize)
    {
        float halfXSize = xSize/2.0f;
        float halfZSize = zSize/2.0f;

        for(float x=-halfXSize;x<=halfXSize;x++)
        {
            for(float z=-halfZSize;z<=halfZSize;z++)
            {
                //scale block coordinates
                GameObject block = new GameObject((x*100),200,(z*100),100,100,100,blackColor,redColor);
                block.Render(this);
            }
        }
    }

}
*/