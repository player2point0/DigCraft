import processing.core.PApplet;


public class GameObject
{
    final protected float gravity = 10;

    protected float x;
    protected float y;
    protected float z;
    protected int xSize;
    protected int ySize;
    protected int zSize;
    private int fillColor;
    private int strokeColor;

    public GameObject(float x, float y, float z, int xSize, int ySize, int zSize)
    {
        this.x = x;
        this.y = y;
        this.z = z;

        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
    }

    public GameObject(float x, float y, float z, int xSize, int ySize, int zSize, int strokeColor, int fillColor)
    {
        this.x = x;
        this.y = y;
        this.z = z;

        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;

        this.strokeColor = strokeColor;
        this.fillColor = fillColor;
    }

    public void Render(PApplet window)
    {
        window.translate(x, y, z);   //move to coordinates

        window.fill(fillColor);   //set fill color
        window.stroke(strokeColor);   //set line color

        window.box(xSize, ySize, zSize);

        window.translate(-x, -y, -z);   //recenter
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
