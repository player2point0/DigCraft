import processing.core.PApplet;

import java.util.ArrayList;

public class MainGame extends PApplet
{
    int redColor;
    int blackColor;
    Player player;
    ArrayList<Block> blocks = new ArrayList<>();

    public void settings()
    {
        size(1000, 1000, "processing.opengl.PGraphics3D");
    }

    public void setup()
    {
        //default colors
        redColor = color(255,0,0,255);
        blackColor = color(0,0,0,255);

        translate(width/2, height/2, 0);   //recenter

        //camera(70.0f, 35.0f, 120.0f, 50.0f, 50.0f, 0.0f, 0.0f, 1.0f, 0.0f);

        player = new Player(0,0,0,100,100,100);

        GenerateTerrain(20,20);
    }

    public void draw()
    {



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
                Block newBlock = new Block((x*100),200,(z*100),100,100,100,blackColor,redColor);
                newBlock.Render(this);

                blocks.add(newBlock);
            }
        }

        System.out.println(blocks.size());
    }

    public static void main(String... args)
    {
        PApplet.main("MainGame");
    }

}
