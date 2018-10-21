import processing.core.PApplet;

import java.awt.*;

public class MainGame extends PApplet
{

    final private int redColor = -65536;
    final private int blackColor = -16777216;

    Player player;
    Terrain terrain;
    Robot mouseRobot;

    public void settings()
    {
        fullScreen("processing.opengl.PGraphics3D");
    }

    public void setup()
    {
        createMouseReseter();
        noCursor();

        translate(width/2, height/2, 0);   //recenter

        terrain = new Terrain(10, 10, this);
        player = new Player(0,-500,0,100,100,100, redColor, blackColor,this, terrain);
        drawCrosshair();

        //camera(0, 0, 1000, 0, 0, 0, 0, 1, 0); //side view
        //camera(1, -1000, 1, 0, 0, 0, 0, 1, 0); //top view
        camera(1000, -1000, 1000, 0, 0, 0, 0, 1, 0); //45d view

        drawAxes(10000);

    }

    public void createMouseReseter()
    {
        try
        {
            mouseRobot = new Robot();
        }
        catch (AWTException e)
        {
            println("Robot class not supported by your system!");
            exit();
        }
    }

    public void resetMouse()
    {
        //wraps mouse round like in snake

        if(mouseX == width-1) mouseRobot.mouseMove(1, mouseY); //if mouse touches right set mouse to the left
        if(mouseX == 0) mouseRobot.mouseMove(width-2, mouseY); //if mouse touches left set mouse to the right

        if(mouseY == height-1) mouseRobot.mouseMove(mouseX, 1); //if mouse touches top set mouse to the bottom
        if(mouseY == 0) mouseRobot.mouseMove(mouseX, height); //if mouse touches bottom set mouse to the top
    }

    public void drawCrosshair()
    {
        /*
        pushMatrix();

        rectMode(CENTER);
        fill(51);
        stroke(255);

        ellipse(0,0,50,50);

        popMatrix();
        */
    }

    public void drawAxes(float size)
    {
        strokeWeight(10);
        //X  - red
        stroke(192,0,0);
        line(-size,0,0,size,0,0);
        //Y - green
        stroke(0,192,0);
        line(0,-size,0,0,size,0);
        //Z - blue
        stroke(0,0,192);
        line(0,0,-size,0,0,size);
        strokeWeight(2);
    }

    public void draw()
    {
        if(frameCount > 10)resetMouse();

        //clear current frame
        background(255);

        player.ApplyGravity();
        player.RotateCamera();
        player.Render();
        if(keyPressed) player.MovePlayer();

        terrain.RenderBlocks();

        drawCrosshair();

        //println("frameRate : "+frameRate);
        drawAxes(10000);

    }

    public static void main(String... args)
    {
        PApplet.main("MainGame");
    }

}
