import processing.core.PApplet;
import processing.core.PVector;

public class Player extends GameObject
{
    final private float MOVE_SPEED = 2;
    private double xRotationAngle;    //measured from below x axis in radians
    private double yRotationAngle;
    PApplet window;


    public Player(float x, float y, float z, int xSize, int ySize, int zSize, PApplet window)
    {
        super(x, y, z, xSize, ySize, zSize);

        this.window = window;

        xRotationAngle = 0;

        SetCameraRotation();
    }

    public void RotateCamera()
    {
        //if mouse moved right then move the camera's centre position right

        if(window.mouseX > window.pmouseX)
        {
            //rotate player right
            xRotationAngle -= 0.01f * MOVE_SPEED;
        }
        else if(window.mouseX < window.pmouseX)
        {
            //rotate player left
            xRotationAngle += 0.01f * MOVE_SPEED;
        }

        if(window.mouseY > window.pmouseY)
        {
            //rotate player up
            yRotationAngle -= 0.01f * MOVE_SPEED;
        }
        else if(window.mouseY < window.mouseY)
        {
            //rotate player down
            yRotationAngle += 0.01f * MOVE_SPEED;
        }

        SetCameraRotation();

        //need way to reset mouse to center
    }

    public void MovePlayer()
    {
        //move in the direction of the camera
        double tempXAngle;

        switch(window.key)
        {
            case 'w' : tempXAngle = 0;
                break;
            case 'a' : tempXAngle = Math.PI / 2;
                break;
            case 's' : tempXAngle = Math.PI;
                break;
            case 'd' : tempXAngle = 3 * (Math.PI / 2);
                break;
        }

        //calculate new position using the temp angle and radius
        //move to new position
        //recalculate the camera's new center
    }

    private void SetCameraRotation()
    {
        PVector centerPos = AngleCalcPos(xRotationAngle, 0, 1);

        window.camera(pos.x,pos.y,pos.z,centerPos.x,centerPos.y,centerPos.z,0,1,0);
    }

    private void addPosition(PVector newPos)
    {
        //update the gameobjects position
        pos.add(newPos);
        //move the camera to the new position
        window.camera(pos.x,pos.y,pos.z,0,0,0,0,1,0);
    }

    private PVector AngleCalcPos(double xTheta, double yTheta, double radius)
    {
        float camX = (float) (radius * Math.sin(xTheta));
        float camY = 0;
        float camZ = (float) (radius * Math.cos(xTheta));

        return new PVector(pos.x+camX, pos.y+camY, pos.z+camZ);
    }
}