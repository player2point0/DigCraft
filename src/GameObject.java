import processing.core.PApplet;
import processing.core.PVector;


public class GameObject
{
    protected PVector pos;
    protected int xSize;
    protected int ySize;
    protected int zSize;
    private int fillColor;
    private int strokeColor;
    protected PApplet window;

    public GameObject(float x, float y, float z, int xSize, int ySize, int zSize, int strokeColor, int fillColor, PApplet window)
    {
        this.pos = new PVector(x, y, z);

        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;

        this.strokeColor = strokeColor;
        this.fillColor = fillColor;

        this.window = window;
    }

    public void Render()
    {
        window.translate(pos.x, pos.y, pos.z);   //move to coordinates

        window.fill(fillColor);   //set fill color
        window.stroke(strokeColor);   //set line color

        window.box(xSize, ySize, zSize);

        window.translate(-pos.x, -pos.y, -pos.z);   //recenter
    }

    public boolean CollidesWith(GameObject other, PVector newPos)
    {
        boolean xCollision = false;
        boolean yCollision = false;
        boolean zCollision = false;

        //test if this objects bounds are within the other objects bounds

        xCollision = ((this.pos.x + xSize) >= (other.pos.x - other.xSize)) || ((this.pos.x - xSize) <= (other.pos.x + other.xSize));

        yCollision = ((this.pos.y + ySize) >= (other.pos.y - other.ySize)) || ((this.pos.y - ySize) <= (other.pos.y + other.ySize));

        zCollision = ((this.pos.z + zSize) >= (other.pos.z - other.zSize)) || ((this.pos.z - zSize) <= (other.pos.z + other.zSize));


        return xCollision || yCollision || zCollision;
    }

}
