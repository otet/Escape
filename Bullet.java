
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Bullet extends GameInit {
	
	private int dx;
	private Player player;
	private Color c;
	
	public Bullet(final Player player, final int dx, final int xPos, final int yPos, final int width, final int height, final Color c ){
		this.player = player;
		this.dx = dx;
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.rect = new Rectangle(xPos, yPos, width, height);
		this.c = c;
	}
	
	@Override
	public void draw (Graphics g) {
		g.setColor(c);
		g.fillRect(xPos, yPos, 5, 2);
	}

	@Override
	void update(final Shoot shooting, final int id) {
		
		/*if (rect.intersects(player.rect)){
			player.setHealth(player.getHealth() - 1);
			shooting.bullets.remove(this); 
					
		} */ 
		if (xPos < 5 || xPos > 595){
			shooting.bullets.remove(this);
		} else {
			xPos += dx;
			rect.x += dx;
		}
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
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
