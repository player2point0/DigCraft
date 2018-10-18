import processing.core.PApplet;
import processing.core.PVector;


public class GameObject
{
    final protected float GRAVITY = 10;

    protected PVector pos;
    protected int xSize;
    protected int ySize;
    protected int zSize;
    private int fillColor;
    private int strokeColor;

    public GameObject(float x, float y, float z, int xSize, int ySize, int zSize)
    {
        this.pos = new PVector(x, y, z);

        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
    }

    public GameObject(float x, float y, float z, int xSize, int ySize, int zSize, int strokeColor, int fillColor)
    {
        this.pos = new PVector(x, y, z);

        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;

        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    public void Render(PApplet window)
    {
        window.translate(pos.x, pos.y, pos.z);   //move to coordinates

        window.fill(fillColor);   //set fill color
        window.stroke(strokeColor);   //set line color

        window.box(xSize, ySize, zSize);

        window.translate(-pos.x, -pos.y, -pos.z);   //recenter
    }

    public boolean CollidesWith(GameObject other)
    {
        boolean xCollision = false;
        boolean yCollision = false;
        boolean zCollision = false;


        return xCollision || yCollision || zCollision;
    }

    public void ApplyGravity()
    {

    }

}
