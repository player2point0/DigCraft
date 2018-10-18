import processing.core.PApplet;
import processing.core.PVector;

public class Player extends GameObject
{
    final private float MOVE_SPEED = 2;
    final private float X_ROTATION_SENS = 0.02f;
    final private float Y_ROTATION_SENS = 0.01f;
    private double xRotationAngle;    //measured from below x axis in radians
    private double yRotationAngle;
    PApplet window;

    public Player(float x, float y, float z, int xSize, int ySize, int zSize, PApplet window)
    {
        super(x, y, z, xSize, ySize, zSize);

        this.window = window;

        xRotationAngle = 0;
        yRotationAngle = 0;

        SetCameraRotation();
    }

    public void RotateCamera()
    {
        //if mouse moved right then move the camera's centre position right

        if(window.mouseX > window.pmouseX)
        {
            //rotate player right
            xRotationAngle -=  X_ROTATION_SENS;
        }
        else if(window.mouseX < window.pmouseX)
        {
            //rotate player left
            xRotationAngle += X_ROTATION_SENS;
        }

        if(window.mouseY > window.pmouseY)
        {
            //rotate player up
            yRotationAngle -= Y_ROTATION_SENS;
            if(yRotationAngle < -Math.PI/2) yRotationAngle = -Math.PI/2;
        }
        else if(window.mouseY < window.pmouseY)
        {
            //rotate player down
            yRotationAngle += Y_ROTATION_SENS;
            if(yRotationAngle > Math.PI/2) yRotationAngle = Math.PI/2;
        }

        SetCameraRotation();
    }

    public void MovePlayer()
    {
        //forward movement triggered by any key press
        //move in the direction of the camera
        PVector newPos = null;

        if(window.key == 'w')
        {
            newPos = AngleCalcPos(xRotationAngle, 0, MOVE_SPEED);
        }
        else if(window.key == 'a')
        {
            newPos = AngleCalcPos(xRotationAngle + Math.PI / 2, 0, MOVE_SPEED);
        }
        if(window.key == 's')
        {
            newPos = AngleCalcPos(xRotationAngle +  Math.PI, 0, MOVE_SPEED);
        }
        if(window.key == 'd')
        {
            newPos = AngleCalcPos(xRotationAngle + 3 * (Math.PI / 2), 0, MOVE_SPEED);
        }

        if(newPos == null) return;

        //calculate new position using the temp angle and radius
        //move to new position
        changePosition(newPos);
        //recalculate the camera's new center
        SetCameraRotation();
    }

    private void SetCameraRotation()
    {
        PVector centerPos = AngleCalcPos(xRotationAngle, -yRotationAngle, 1);

        window.camera(pos.x,pos.y,pos.z,centerPos.x,centerPos.y,centerPos.z,0,1,0);
    }

    private void changePosition(PVector newPos)
    {
        //update the gameobjects position
        pos = newPos;
        //move the camera to the new position
        window.camera(pos.x,pos.y,pos.z,0,0,0,0,1,0);
    }

    private PVector AngleCalcPos(double Theta, double Phi, double radius)
    {
        /*
        float camX = (float) (radius * Math.sin(Theta));
        float camY = 0;
        float camZ = (float) (radius * Math.cos(Theta));
        */

        float camX = (float) (radius * Math.sin(Theta) * Math.cos(Phi));
        float camY = (float) (radius * Math.sin(Phi));
        float camZ = (float) (radius * Math.cos(Theta));

        //System.out.println(camY);

        return new PVector(pos.x+camX, pos.y+camY, pos.z+camZ);
    }
}