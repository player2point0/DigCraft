import processing.core.PApplet;

public class MainGame extends PApplet
{
    Player player;
    Terrain terrain;

    public void settings()
    {
    	fullScreen("processing.opengl.PGraphics3D");
        //size(1000, 1000, "processing.opengl.PGraphics3D");
    }

    public void setup()
    {	
    	//noCursor(); 	
        translate(width/2, height/2, 0);   //recenter

        player = new Player(10,-10,10,20,-10,20, this);
        terrain = new Terrain(20, 20);
    }

    public void keyPressed()
    {
        player.MovePlayer();
    }
    
    public void mouseMoved()
    {
        player.RotateCamera();
    }

    public void draw()
    {
        //clear current frame
        background(255);
        terrain.RenderBlocks(this);

        println("frameRate : "+frameRate);
    }

    public static void main(String... args)
    {
        PApplet.main("MainGame");
    }

}
