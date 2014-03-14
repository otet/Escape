

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Block extends GameInit {
	
	private int id;
	private Color c;
	private Block block;
	
	
	
	//Player Creation
	


	public Block(final Block block, final int xPos, final int yPos, final int width, final int height, final Color c ){
		this.setBlock(block);
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.rect = new Rectangle(xPos, yPos, 20, 20);
		this.c = c;
		
	}
	
	
	@Override
	public void draw (Graphics g) {
		g.setColor(c);
		g.fillRect(xPos, yPos, 20, 20);
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
		
		
	
			
			
			
			}


	public Block getBlock() {
		return block;
	}


	public void setBlock(Block block) {
		this.block = block;
	}


	public void setColor(Color black) {
		// TODO Auto-generated method stub
		
	}
		
	}
	



	

	
	
	
	
	

