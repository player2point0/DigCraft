import processing.core.PApplet;

public class Player extends GameObject
{
    final private float moveSpeed = 1;


    public Player(float x, float y, float z, int xSize, int ySize, int zSize, PApplet window)
    {
        super(x, y, z, xSize, ySize, zSize);

        window.camera(x,y,z,0,0,0,0,1,0);
        //make new P3D camera
        //rotate camera based on mouse position
        //move player using aswd/arrow keys
    }

    public void RotateCamera(PApplet window)
    {
        //if mouse moved right then move the camera's centre position right


    }

    public void MovePlayer(PApplet window)
    {
        //move in the direction of the camera

        switch(window.key)
        {
            case 'w' :
        }


    }

    private void addPosition(float x, float y, float z, PApplet window)
    {
        x += x;
        y += y;
        z += z;

        window.camera(x,y,z,0,0,0,0,1,0);
    }

}
