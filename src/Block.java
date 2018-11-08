import processing.core.PApplet;

public class Block extends GameObject
{
    public Block(float x, float y, float z, int xSize, int ySize, int zSize, int strokeColor, int fillColor, PApplet window)
    {
        super(x, y, z, xSize, ySize, zSize, strokeColor, fillColor, window);
    }

    public void SelectBlock()
    {
        this.fillColor = -65536;
        System.out.println(this);
    }
}
