import processing.core.PApplet;
import java.awt.*;

public class MainGame extends PApplet
{
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

        translate(width/2, height/2, 0);   //recenter

        player = new Player(10,-10,10,20,-10,20, this);
        terrain = new Terrain(20, 20);
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

    public void keyPressed()
    {
        player.MovePlayer();
    }

    public void resetMouse()
    {
        //wraps mouse round like in snake

        if(mouseX == width-1) mouseRobot.mouseMove(1, mouseY); //if mouse touches right set mouse to the left
        if(mouseX == 0) mouseRobot.mouseMove(width-2, mouseY); //if mouse touches left set mouse to the right
    }

    public void draw()
    {
        if(frameCount > 10)resetMouse();

        //clear current frame
        background(255);

        player.RotateCamera();

        terrain.RenderBlocks(this);

        //println("frameRate : "+frameRate);
    }

    public static void main(String... args)
    {
        PApplet.main("MainGame");
    }

}
