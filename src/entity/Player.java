package entity;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
/**
 * player class 
 * @author jlb74
 *
 */
public class Player extends Entity {
	GamePanel gp;
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;
	/**
	 * sets up game panel image key reader and image
	 * @param gp game panel
	 * @param keyH key pressed
	
	 */
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp =gp;
		this.keyH= keyH;
		
		screenX = gp.screenWidth/2 -(gp.tileSize)/2;
		screenY = gp.screenHeight/2 - (gp.tileSize)/2;
		setDeafaultValues();
		getPlayerImage();
	}
	/**
	 * sets the position and speed of the player and any other deafult values
	 */
	public void setDeafaultValues() {
		worldX = gp.tileSize * 8;
		worldY= gp.tileSize * 8;
		speed =4;
		direction = "down";
		
	}
	/**
	 * sets the image to the direction
	 */
	public void getPlayerImage() {
		try {
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/left1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/left2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/right1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/right2.png"));
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * sets the direction when key is pressed
	 */
	public void update() {
		if(keyH.upPressed == true || keyH.downPressed == true || keyH.rightPressed == true || keyH.leftPressed ==true) {
			if (keyH.upPressed == true) {
				direction ="up";
				worldY -= speed;
			}
			else if (keyH.downPressed == true) {
				direction="down";
				worldY += speed;
			}
			else if (keyH.leftPressed == true){
				direction="left";
				worldX -= speed;
			}
			else if (keyH.rightPressed == true) {
				direction=	"right";
				worldX += speed;
			}
			
			spriteCounter++; 
			if(spriteCounter > 10) {
				if(spriteNum == 0) {
					spriteNum = 1;
				}
				else if (spriteNum ==1) {
					spriteNum = 0;
				}
				spriteCounter =0;
			}
		}

	}
	/**
	 * changes image to the direction 
	 * @param g2 images for 2d
	 */
	public void draw(Graphics2D g2) {
		BufferedImage image =  null;
		switch(direction) {
		case"up":
			if(spriteNum ==0) {
				image =up1;
			}
			if(spriteNum ==1) {
				image =up2;
			}
			break;
		case "down":
			if(spriteNum ==0) {
				image = down1;
			}
			if(spriteNum ==1) {
				image =down2;
			}
			
			break;
		case "left":
			if(spriteNum ==0) {
				image = left1;
			}
			if(spriteNum ==1) {
				image =left2;
			}
			break;
		case "right":
			if(spriteNum ==0) {
				image = right1;
			}
			if(spriteNum ==1) {
				image =right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);	}
	
}
