

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameInit {
	
	private int id;
	private Color c;
	public boolean playerhit = false;
	
	
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
		g.fillRect(xPos, yPos, 20, 45);
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
	
			if (shooting.player1Left){
				if(!(xPos < 10)){
					xPos-=3;
					rect.x-=3;
					
		}
				}
			if (shooting.player1Right){
				if (!(xPos > shooting.getWidth() - 25)){
					xPos+=3;
					rect.x+=3;
			}
			
		}



			if(shooting.player1.xPos <= shooting.block1.xPos+20 && shooting.player1.xPos+20 >= shooting.block1.xPos && shooting.player1.yPos-40 <= shooting.block1.yPos   && !playerhit && !shooting.block1.isHit())
			{
				shooting.player1.setHealth(shooting.player1.getHealth() - 1);
				playerhit = true;
				System.out.println("is hit: "+shooting.player1.xPos);
			}else{
				if(shooting.player1.xPos > shooting.block1.xPos+20 || shooting.player1.xPos+20 < shooting.block1.xPos && shooting.player1.yPos-40 <= shooting.block1.yPos  ){
					playerhit = false;
					
				}
			}
			if(shooting.player1.xPos <= shooting.block2.xPos+20 && shooting.player1.xPos+20 >= shooting.block2.xPos && shooting.player1.yPos-40 <= shooting.block2.yPos   && !playerhit && !shooting.block2.isHit())
			{
				shooting.player1.setHealth(shooting.player1.getHealth() - 1);
				playerhit = true;
				System.out.println("is hit: "+shooting.player1.xPos);
			}else{
				if(shooting.player1.xPos > shooting.block2.xPos+20 || shooting.player1.xPos+20 < shooting.block2.xPos && shooting.player1.yPos-40 <= shooting.block2.yPos  ){
					playerhit = false;
					
				}
			}
			if(shooting.player1.xPos <= shooting.block3.xPos+20 && shooting.player1.xPos+20 >= shooting.block3.xPos && shooting.player1.yPos-40 <= shooting.block3.yPos   && !playerhit && !shooting.block3.isHit())
			{
				shooting.player1.setHealth(shooting.player1.getHealth() - 1);
				playerhit = true;
				System.out.println("is hit: "+shooting.player1.xPos);
			}else{
				if(shooting.player1.xPos > shooting.block3.xPos+20 || shooting.player1.xPos+20 < shooting.block3.xPos && shooting.player1.yPos-40 <= shooting.block3.yPos  ){
					playerhit = false;
					
				}
			}
			if(shooting.player1.xPos <= shooting.block4.xPos+20 && shooting.player1.xPos+20 >= shooting.block4.xPos && shooting.player1.yPos-40 <= shooting.block4.yPos   && !playerhit && !shooting.block4.isHit())
			{
				shooting.player1.setHealth(shooting.player1.getHealth() - 1);
				playerhit = true;
				System.out.println("is hit: "+shooting.player1.xPos);
			}else{
				if(shooting.player1.xPos > shooting.block4.xPos+20 || shooting.player1.xPos+20 < shooting.block4.xPos && shooting.player1.yPos-40 <= shooting.block4.yPos  ){
					playerhit = false;
					
				}
			}
			if(shooting.player1.xPos <= shooting.block5.xPos+20 && shooting.player1.xPos+20 >= shooting.block5.xPos && shooting.player1.yPos-40 <= shooting.block5.yPos   && !playerhit && !shooting.block5.isHit())
			{
				shooting.player1.setHealth(shooting.player1.getHealth() - 1);
				playerhit = true;
				System.out.println("is hit: "+shooting.player1.xPos);
			}else{
				if(shooting.player1.xPos > shooting.block5.xPos+20 || shooting.player1.xPos+20 < shooting.block5.xPos && shooting.player1.yPos-40 <= shooting.block5.yPos  ){
					playerhit = false;
					
				}
			}
			if(shooting.player1.xPos <= shooting.block6.xPos+20 && shooting.player1.xPos+20 >= shooting.block6.xPos && shooting.player1.yPos-40 <= shooting.block6.yPos   && !playerhit && !shooting.block6.isHit())
			{
				shooting.player1.setHealth(shooting.player1.getHealth() - 1);
				playerhit = true;
				System.out.println("is hit: "+shooting.player1.xPos);
			}else{
				if(shooting.player1.xPos > shooting.block6.xPos+20 || shooting.player1.xPos+20 < shooting.block6.xPos && shooting.player1.yPos-40 <= shooting.block6.yPos  ){
					playerhit = false;
					
				}
			}
	}
		
	}
	



	

	
	
	
	
	

