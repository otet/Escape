

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Block extends GameInit {
	
	private int id;
	private Color c;
	private Block block;
	private boolean hit;
	private int dy;
	
	
	
	//Player Creation
	


	public Block(final Block block, final int xPos, final int yPos, final int dy, final int width, final int height, final Color c, final boolean hit ){
		this.setBlock(block);
		this.xPos = xPos;
		this.yPos = yPos;
		this.dy = dy;
		this.height = height;
		this.width = width;
		this.rect = new Rectangle(xPos, yPos, 20, 20);
		this.c = c;
		this.setHit(hit);
		
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
		
			if (shooting.block1.getyPos()>= 490){
				shooting.block1.setyPos(0);
			}
			if (shooting.block2.getyPos()>= 490){
				shooting.block2.setyPos(0);
			}
			if (shooting.block3.getyPos()>= 490){
				shooting.block3.setyPos(0);
			}
			if (shooting.block4.getyPos()>= 490){
				shooting.block4.setyPos(0);
			}
			if (shooting.block5.getyPos()>= 490){
				shooting.block5.setyPos(0);
			}
			if (shooting.block6.getyPos()>= 490){
				shooting.block6.setyPos(0);
			}
		if(!shooting.block1.isHit()){
				yPos += dy;
			} 
			else if(!shooting.block2.isHit()){
				yPos += dy;
			}
			else if(!shooting.block3.isHit()){
				yPos += dy;
			}
			else if(!shooting.block4.isHit()){
				yPos += dy;
			}
			else if(!shooting.block5.isHit()){
				yPos += dy;
			}
			else if(!shooting.block6.isHit()){
				yPos += dy;
			}
			
			
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


	public boolean isHit() {
		return hit;
	}


	public void setHit(boolean hit) {
		this.hit = hit;
	}


	public int getDy() {
		return dy;
	}


	public void setDy(int dy) {
		this.dy = dy;
	}
		
	}
	



	

	
	
	
	
	

