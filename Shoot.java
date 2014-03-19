
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
	public Block block1;
	public Block badBlock;
	private Graphics graphics;
	public Image image = null;

	public boolean player1Left = false;
	public boolean player1Right = false;

	CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();
	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<Block>();
	Thread anim;
	
	
	
	public void init() {
		//setTitle("Galagamza");
		
		this.setSize(width,height);
		setBackground(Color.WHITE);
		addKeyListener(new KeyL());
		setFocusable(true);
		setVisible(true);
		
		player1 = new Player(200, 427, 20, 90, 10, Color.BLACK);
		
		block1 = new Block(block1, 200, 100, 20, 20, Color.BLACK, false);
		
		Block evilBlock = new Block(badBlock, 250, 85, 20, 20, Color.BLACK, false);
		blocks.add(evilBlock);
		
		
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
	
		
	
		
		
	}
	
	
	
	public void paintComponent (Graphics g){
		if (player1.getHealth() > 0 ){
		for (Bullet bullet : bullets){
			bullet.draw(g);
			}
		for (Block evilBlock : blocks){
			evilBlock.draw(g);
		//	evilBlock.update(this, 0);
			}
		} else if (player1.getHealth() == 0){
			g.setColor(Color.yellow);
			g.drawString("You Lose!", 250, 190);
		} 
		
		
		g.setColor(Color.BLACK);
    	g.drawString("Health: " + Integer.toString(player1.getHealth()), 10, 15);
    
	
    	
    	
		player1.draw(g);

	    if(block1.isHit()){
	    	
	    }else{
		    block1.draw(g);
		   
	    }
		
		
	}
	
	public void gameUpdate(){
		player1.update(this, 1);	
		block1.update(this, 2);
		
		for (Bullet bullet : bullets){
			bullet.update(this, 0);
			}
		
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
				Bullet player1Bullet = new Bullet(player1, -8, player1.getxPos() + 9, player1.getyPos(), 2, 10, Color.BLACK);
				bullets.add(player1Bullet); 
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
			gameUpdate();
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {}
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;







}
