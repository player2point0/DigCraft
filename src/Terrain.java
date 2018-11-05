import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Terrain
{
    private ArrayList<Block> blocks = new ArrayList<>();

    private int redColor = -65536;
    private int blackColor = -16777216;

    public Terrain (int xSize, int zSize, PApplet window)
    {
        float halfXSize = xSize/2.0f;
        float halfZSize = zSize/2.0f;

        //place blocks in a rectangle

        blocks.add(new Block(100,100,100,100,100,100,blackColor,redColor,window));

        for(float x=-halfXSize;x<=halfXSize;x++)
        {
            for(float z=-halfZSize;z<=halfZSize;z++)
            {
                //scale block coordinates
                Block newBlock = new Block((x*100),200,(z*100),100,100,100, blackColor, redColor, window);

                blocks.add(newBlock);
            }
        }
    }

    public void RenderBlocks()
    {
        for(int i=0;i<blocks.size();i++)
        {
            blocks.get(i).Render();
        }
    }

    public boolean CollisionAtNewPos(PVector newPos, GameObject obj)
    {
        for (int i = 0;i<blocks.size();i++)
        {
            if(obj.CollidesWith(blocks.get(i), newPos))
            {
                //System.out.println(i);
                System.out.println("block : " + blocks.get(i) + "\nplayer : " + obj);

                return true;
            }
        }

        //return true;
        return false;
    }

}
