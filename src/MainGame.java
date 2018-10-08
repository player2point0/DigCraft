import processing.core.PApplet;

public class MainGame extends PApplet
{
    Player player;
    Terrain terrain;

    public void settings()
    {
        size(1000, 1000, "processing.opengl.PGraphics3D");
    }

    public void setup()
    {
        translate(width/2, height/2, 0);   //recenter

        //player = new Player(0,-50,0,100,100,100, this);
        terrain = new Terrain(20, 20);
    }

    public void keyPressed()
    {
        //player.MovePlayer(this);
    }

    public void draw()
    {
        //clear current frame
        background(255);

        camera(50, -50, 50, 0, 0, 0, 0.0f, 1.0f, 0.0f);

        //player.RotateCamera(this);
        terrain.RenderBlocks(this);

        println(frameRate);
    }

    public static void main(String... args)
    {
        PApplet.main("MainGame");
    }

}
