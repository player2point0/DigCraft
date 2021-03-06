import processing.core.PApplet;
import processing.core.PVector;

import java.awt.*;

public class Player extends GameObject
{
    final private float MOVE_SPEED = 5;
    final private float X_ROTATION_SENS = 0.02f;
    final private float Y_ROTATION_SENS = 0.01f;
    final private int RAY_CAST_MAX_DIS = 1000;
    final protected float GRAVITY = 4;

    private double xRotationAngle;    //measured from below x axis in radians
    private double yRotationAngle;
    private Terrain terrain;

    public Player(float x, float y, float z, int xSize, int ySize, int zSize, int strokeColor, int fillColor, PApplet window, Terrain terrain)
    {
        super(x, y, z, xSize, ySize, zSize, strokeColor, fillColor, window);

        this.terrain = terrain;
        xRotationAngle = 0;
        yRotationAngle = 0;

        //SetCameraRotation();
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
            //rotate player down
            yRotationAngle += Y_ROTATION_SENS;
            if(yRotationAngle > Math.PI/2) yRotationAngle = Math.PI/2;
        }
        else if(window.mouseY < window.pmouseY)
        {
            //rotate player up
            yRotationAngle -= Y_ROTATION_SENS;
            if(yRotationAngle < -Math.PI/2) yRotationAngle = -Math.PI/2;
        }

        //SetCameraRotation();
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
        else if(window.key == 's')
        {
            newPos = AngleCalcPos(xRotationAngle +  Math.PI, 0, MOVE_SPEED);
        }
        else if(window.key == 'd')
        {
            newPos = AngleCalcPos(xRotationAngle + 3 * (Math.PI / 2), 0, MOVE_SPEED);
        }

        else if(window.key == 32)   //space bar
        {
            Jump();
        }

        if(newPos == null) return;

        //calculate new position using the temp angle and radius
        //check if new position will result in a collision
        boolean collisionAtNewPos = terrain.CollisionAtNewPos(newPos,this);
        //if no collision then change position
        if (!collisionAtNewPos) changePosition(newPos);
    }

    private void SetCameraRotation()
    {
        PVector centerPos = AngleCalcPos(xRotationAngle, yRotationAngle, 1);

        window.camera(pos.x,pos.y,pos.z,centerPos.x,centerPos.y,centerPos.z,0,1,0);
    }

    private void changePosition(PVector newPos)
    {
        //update the gameObjects position
        pos = newPos;
        //move the camera to the new position
        //window.camera(pos.x,pos.y,pos.z,0,0,0,0,1,0);
        //recalculate the camera's new center
        //SetCameraRotation();
    }

    private PVector AngleCalcPos(double Theta, double Phi, double radius)
    {
        //still needs tweaking

        float posX = (float) (radius * Math.sin(Theta) * Math.cos(Phi));
        float posY = (float) (radius * Math.sin(Phi));
        float posZ = (float) (radius * Math.cos(Theta));

        return new PVector(pos.x+posX, pos.y+posY, pos.z+posZ);
    }

    public void ApplyGravity()
    {
        //set position to a position vertically down times gravity constant
        PVector newPos = AngleCalcPos(-Math.PI/2, Math.PI/2, GRAVITY);
        //check if new position will result in a collision
        boolean collisionAtNewPos = terrain.CollisionAtNewPos(newPos,this);
        //if no collision then change position
        if (!collisionAtNewPos) changePosition(newPos);
    }

    public void Jump()
    {

    }

    public void RayCast()
    {
        //create an imaginary path
        //starting at the player's position
        //with a length of max ray cast distance
        //and in the direction that the player's camera is looking
        //move incrementally along the line and check for a collision with blocks in the terrain
        //stop if there is a collision or if at the end of the line
    }

    public void DrawCrossHair()
    {
        //draw a sphere in front of the player
        PVector pos = AngleCalcPos(xRotationAngle, yRotationAngle, 100);

        super.window.translate(pos.x, pos.y, pos.z);   //move to coordinates

        super.window.fill(fillColor);   //set fill color
        super.window.stroke(fillColor);   //set line color

        super.window.sphere(5);

        super.window.translate(-pos.x, -pos.y, -pos.z);   //recenter
    }
}