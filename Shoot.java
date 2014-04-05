
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*	
 * 
 *  
 *  * Use Left and Right arrow keys to move Player *
 *  
 *  
 *  Created by José González & Zayed Al Falasi
 *  Prof. Michael Slattery
 *  Programming Computer Games
 *  Marquette University
 *  Spring 2014 
 */

public class Shoot extends JApplet implements  Runnable{
	
	
	int width = 400;
	int height = 500;
	
	public Player player1;
	
	public Block block1;
	public Block block2;
	public Block block3;
	public Block block4;
	public Block block5;
	public Block block6;
	public Block badBlock;
	private Graphics graphics;
	public Image image = null;
	public boolean gamestart = false;
	public boolean player1Left = false;
	public boolean player1Right = false;

	CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();
//	CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<Block>();
	

	private JButton start = new JButton ("Play Game");
    String intro = "Waddup";

	
	Thread anim = null;
	
	
	
	public void init() {
		//setTitle("Galagamza");
		
		this.setSize(width,height);
		setBackground(Color.WHITE);
		addKeyListener(new KeyL());
		setFocusable(true);
		setVisible(true);

	/*	Block evilBlock = new Block(badBlock, 250, 85, 20, 20, Color.BLACK, false);
		blocks.add(evilBlock);*/
		player1 = new Player(200, 427, 20, 90, 300, Color.darkGray);
		
		block1 = new Block(block1, 200, 100, 2, 20, 20, Color.BLACK, false);
		block2 = new Block(block2, 100, 25, 3, 20, 20, Color.BLACK, false);
		block3 = new Block(block3, 370, 60, 2, 20, 20, Color.BLACK, false);
		block4 = new Block(block4, 270, 8, 1, 20, 20, Color.BLACK, false);
		block5 = new Block(block5, 145, 4, 2, 20, 20, Color.BLACK, false);
		block6 = new Block(block6, 40, 42, 3, 20, 20, Color.BLACK, false);

		
		System.out.println("init() done");

	}
	

	
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
		if(gamestart){

		if (player1.getHealth() > 0 ){
		for (Bullet bullet : bullets){
			bullet.draw(g);
			}
		/*for (Block evilBlock : blocks){
			evilBlock.draw(g);
		//	evilBlock.update(this, 0);
			}*/
		} else if (player1.getHealth() <= 0){
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
			    
		if(block2.isHit()){
			
			  }else{
			block2.draw(g);  
			    }

		if(block3.isHit()){
			
		}else{
		    block3.draw(g);		   
		}

		if(block4.isHit()){
			
		}else{
		    block4.draw(g);
		}
		
		if(block5.isHit()){
	    	
	    }else{
		    block5.draw(g);	   
	    }
		
	    if(block6.isHit()){
	    	
	    }else{
		    block6.draw(g);		   
	    }
		
		}else{
			g.drawString("Escape Game!", 150,100);
			g.drawString("to escape, you need to dodge the squares coming down!", 50,150);
			g.drawString("now please hit space to start the game", 100,200);
			
		}
	}
	
    private void createGUI() {
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.gray);
        panel.setSize(600,500);
        panel.add(start);
        panel.setOpaque(true); 
        setContentPane(panel);
        this.add(panel);
        
      
        
    }   
	
	public void gameUpdate(){
		player1.update(this, 1);	
		block1.update(this, 2);
		block2.update(this, 2);
		block3.update(this, 2);
		block4.update(this, 2);
		block5.update(this, 2);
		block6.update(this, 2);
		
		for (Bullet bullet : bullets){
			bullet.update(this, 0);
			}
		
	}
	
	/*public void setLevel1()
	{
		bullets = new Bullet[5];
		bullets[1] = new Bullet(player1, -8, player1.getxPos() + 9, player1.getyPos(), 2, 10, Color.BLACK);
	}
	*/
	
/*	public void collision (){
		ListIterator<Block> blockIterator = blocks.listIterator();
	   
		for(Bullet b : bullets){
	        Rectangle rB = b.getBoundingBox();
	      

	        for(Block t : blocks){
	            Rectangle rE = t.getBoundingBox();
	            while (blockIterator.hasNext()) {
				    Rectangle bb = blockIterator.next().getBoundingBox();
				    if(rB.intersects(bb)) {
				        blockIterator.remove();
				    }
				}
	          
	            if(rB.intersects(rE)){
	               blocks.remove(t);
	               System.out.println("Got Hit");
	            }
	        }
	    
	
		
	
	    }
	    
	}*/
	
	
	class KeyL extends KeyAdapter {
		
	
	public void keyPressed(KeyEvent t) {
		
		int c = t.getKeyCode();
		switch(c){
		
			
		case KeyEvent.VK_LEFT:
			player1Left = true;
			break;
		case KeyEvent.VK_ENTER:
			gamestart = true;
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
			if(gamestart){
			gameUpdate();
			}
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
