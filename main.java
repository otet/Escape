import java.applet.*;
import java.awt.*;

/**
 * Programming Computer Games
 * 
 *
 * @author Zayed Al Falasi and José González
<<<<<<< HEAD
 * 
 *
 * @version Jan 2014
=======
 * @version Mar 2014
>>>>>>> af05134f16f8a180cbc66f80dab95f5e5f66e456
 */

public class main extends Applet implements Runnable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

Thread anim = null;  // animation thread
  
  public static final int WIDTH = 700; // Applet size
  public static final int HEIGHT = 500;
  

  
  Image offscreen = null;
  Graphics offgr;
  
  public void init() {

  }

  public void start() {	
  	anim = new Thread(this);
  	anim.start();
  } 
  
  public void update(Graphics g)
  {
    // If the buffer doesn't exist, set it up
  	if (offscreen == null)
  	{
  		offscreen = createImage(WIDTH,HEIGHT);
  		offgr = offscreen.getGraphics();
  	}
  	// Call paint() to draw on the offscreen buffer
  	paint(offgr);
  	// And then copy that image to the screen
  	g.drawImage(offscreen,0,0,null);
  }
 
  public void paint(Graphics g) {
  
    // Draw a black background
    g.setColor(Color.black);
    g.fillRect(0,0,WIDTH,HEIGHT);
    

  }
  
  public void run() {
    while (anim != null)
    {
      // update positions for next frame

      
      repaint();
      // wait a bit (frames per second about 33)
      try {
      	Thread.sleep(30);
      } catch (InterruptedException e) {}
    }
  }
  
  public void stop() {  
    anim = null;  // stop animation thread
  } 
}
