
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JApplet;

/*	
 *  *Use W, S and Space for Player 1*
 *  
 *  * Use Up Arrow, Down Arrow, and Enter for Player 2 *
 *  
 *  Created by José González & Zayed Al Falasi
 *  Prof. Michael Slattery
 *  Programming Computer Games
 *  Marquette University
 *  Spring 2014 
 */

public class Shoot extends JApplet implements  Runnable {
	
	
	int width = 400;
	int height = 500;
	
	private Player player1;
	private Player player2;
	private Graphics graphics;
	public Image image = null;

	public boolean player1Left = false;
	public boolean player1Right = false;

	CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();

	Thread anim;
	
	
	
	public void init() {
		//setTitle("Galagamza");
		
		this.setSize(width,height);
		setBackground(Color.BLACK);
		addKeyListener(new KeyL());
		setFocusable(true);
		setVisible(true);
		
		player1 = new Player(200, 407, 20, 90, 10, Color.green);
		

		
		
		System.out.println("init() done");

	}
	
	/*public Shoot(){
	
	}*/
	

	
	public void start(){
		
		anim = new Thread(this);
		anim.start();
		
		System.out.println("start() done");
	}
	
	public void paint (Graphics g){

		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();
		
		
		paintComponent(graphics);
		g.drawImage(image, 0, 0, this);
		repaint();
		
	
		
		
	}
	
	
	
	public void paintComponent (Graphics g){
		if (player1.getHealth() > 0 ){
		for (Bullet bullet : bullets){
			bullet.draw(g);
			bullet.update(this, 0);
			}
		} else if (player1.getHealth() == 0){
			g.setColor(Color.yellow);
			g.drawString("Player 2 Wins!", 250, 190);
		} else if (player2.getHealth() == 0){
			g.setColor(Color.yellow);
			g.drawString("Player 1 Wins!", 250, 190);
		}
		
		g.setColor(Color.white);
    	g.drawString("Health: " + Integer.toString(player1.getHealth()), 10, 15);
    
	
    	
    	
		player1.draw(g);
	    player1.update(this, 1);

		
		
	}
	
	
	class KeyL extends KeyAdapter {
		
	
	public void keyPressed(KeyEvent t) {
		
		int c = t.getKeyCode();
		switch(c){
		
			
		case KeyEvent.VK_LEFT:
			player1Left = true;
			break;
		
		case KeyEvent.VK_RIGHT:
			player1Right = true;
			break;
		} 
		
	}
	
		
	
	public void keyReleased(KeyEvent w) {
			
		int c = w.getKeyCode();
		switch(c){
		
				
			case KeyEvent.VK_LEFT:
				player1Left = false;
				break;
			
			case KeyEvent.VK_RIGHT:
				player1Right = false;
				break;
				
			case KeyEvent.VK_SPACE:
				Bullet player1Bullet = new Bullet(player2, 1, player1.getxPos() + 20, player1.getyPos() + 45, 4 , 4, Color.white);
				bullets.add(player1Bullet);
				break;
				
			case KeyEvent.VK_ENTER:
				Bullet player2Bullet = new Bullet(player1, -1, player2.getxPos() - 4, player2.getyPos() + 45, 4 , 4, Color.white);
				bullets.add(player2Bullet);
				break;
		} 
		
	
	}
		public void keyTyped(KeyEvent arg0) {
		
		
	}

}
	
	
	
	

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	
	public void stop(){
    	anim = null;
    	System.out.println("stop(); check.");
    }
	
	public void run() {
		while (anim != null) {
			player1.update(this, 1);

			
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;







}
