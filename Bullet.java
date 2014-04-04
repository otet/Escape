
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bullet extends GameInit {
	
	private int dy;
	private Player player;
	private Block block;
	private Color c;
	
	public Bullet(final Player player, final int dy, final int xPos, final int yPos, final int width, final int height, final Color c ){
		this.player = player;
		this.dy = dy;
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.c = c;
	}
	
	@Override
	public void draw (Graphics g) {
		g.setColor(c);
		g.fillRect(xPos, yPos, 2, 5);
	}
	


	@Override
	void update(final Shoot shooting, final int id) {
		
	// Code for subtracting health when player is subject to crash
		
		/*if (rect.intersects(player.rect)){
			player.setHealth(player.getHealth() - 1);
			shooting.bullets.remove(this); 
					
		} */ 
		
		
		if ((yPos < 5 || yPos > 496) && !shooting.block1.isHit()){
		
			shooting.bullets.remove(this);
		} else {
			yPos += dy;
		
		}
		
		/** Newer version of object collision**/
		
		if (xPos > 200 && xPos<220 && yPos >100 && yPos<220 && !shooting.block1.isHit()){
			System.out.println("touched ");
			//player.health -=1;
			
			shooting.block1.setHit(true);
			
			shooting.bullets.remove(this);
		
			//shooting.blocks.remove(this);
		} else {
			yPos += dy;
			//rect.y += dy;
		}
		
		
		
		/*if (rect.intersects(block.rect)){
			
		shooting.bullets.remove(this); 
				
	}  */
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	@Override
	Image getImage(String img) {
		return Toolkit.getDefaultToolkit().getImage(img);

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
