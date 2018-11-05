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
        //refactor

        //test if this objects bounds are within the other objects bounds


        boolean xCollision = ((this.pos.x + xSize/2.0) < (other.pos.x + other.xSize/2.0) && (this.pos.x + xSize/2.0) > (other.pos.x - other.xSize/2.0)) || ((this.pos.x - xSize/2.0) < (other.pos.x + other.xSize/2.0) && (this.pos.x - xSize/2.0) > (other.pos.x - other.xSize/2.0));
        boolean yCollision = ((this.pos.y + ySize/2.0) < (other.pos.y + other.ySize/2.0) && (this.pos.y + ySize/2.0) > (other.pos.y - other.ySize/2.0)) || ((this.pos.y - ySize/2.0) < (other.pos.y + other.ySize/2.0) && (this.pos.y - ySize/2.0) > (other.pos.y - other.ySize/2.0));
        boolean zCollision = ((this.pos.z + zSize/2.0) < (other.pos.z + other.zSize/2.0) && (this.pos.z + zSize/2.0) > (other.pos.z - other.zSize/2.0)) || ((this.pos.z - zSize/2.0) < (other.pos.z + other.zSize/2.0) && (this.pos.z - zSize/2.0) > (other.pos.z - other.zSize/2.0));

        return xCollision && yCollision && zCollision;
    }

    @Override
    public String toString()
    {
        return "pos : " + pos + " size : " + xSize;
    }
}
