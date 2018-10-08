import processing.core.PApplet;

import java.util.ArrayList;

public class Terrain
{
    private ArrayList<Block> blocks = new ArrayList<>();

    private int redColor = -65536;
    private int blackColor = -16777216;

    public Terrain (int xSize, int zSize)
    {
        float halfXSize = xSize/2.0f;
        float halfZSize = zSize/2.0f;

        //place blocks in a rectangle
        for(float x=-halfXSize;x<=halfXSize;x++)
        {
            for(float z=-halfZSize;z<=halfZSize;z++)
            {
                //scale block coordinates
                Block newBlock = new Block((x*100),200,(z*100),100,100,100,blackColor,redColor);

                blocks.add(newBlock);
            }
        }

    }

    public void RenderBlocks(PApplet window)
    {
        for(int i=0;i<blocks.size();i++)
        {
            blocks.get(i).Render(window);
        }
    }


}
