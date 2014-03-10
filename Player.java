

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameInit {
	
	private int id;
	private Color c;
	
	
	
	//Player Creation
	


	public Player(final int xPos, final int yPos, final int width, final int height, final int health, final Color c ){
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.rect = new Rectangle(xPos, yPos, 20, 90);
		this.c = c;
		this.health = health;
	}
	
	
	@Override
	public void draw (Graphics g) {
		g.setColor(c);
		g.fillRect(xPos, yPos, 20, 90);
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	Image getImage(String img) {
		return Toolkit.getDefaultToolkit().getImage(img);
	}


	@Override
	void update(final Shoot shooting, final int id) {
		if (id == 1){
			if (shooting.player1Left){
				if(!(xPos < 26)){
					xPos--;
					rect.x--;
					
		
			}else if (shooting.player1Right){
				if (!(xPos > shooting.getHeight() - 96)){
					xPos++;
					rect.x++;
			}
			
		}
			
			
			}
			}
		}
		
	



	

	}
	
	
	

