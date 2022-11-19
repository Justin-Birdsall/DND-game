package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

/**
 * Gampanel sets up everything that displays on the GUI
 * @author jlb74
 *
 */
public class GamePanel extends JPanel implements Runnable{
	//SCREEN SETTINGS FOR THE GAME
	/**
	 * this is setting the game by 16x16 pixels
	 */
	final int originalTileSize = 16; //this is setting the game by 16 x 16 
	/**
	 * this is scaling up the pixels by a factor of 3 the 16 pixels dont look incredibly small
	 */
	final int scale =3; //scales the pixels up so the char doesn't look small
	/**
	 * this is setting the tile size by pixels * the scale that you want your game to be at
	 */
	public final int tileSize = originalTileSize * scale;
	/**
	 * this is the ammount of colums for the GUI
	 */
	final int maxScreenCol=16;
	/**
	 * this is the amount of rows in the GUi
	 */
	final int maxScreenRow =12;
	/**
	 * sets up the width of the GUI
	 */
	public final int screenWidth =tileSize * maxScreenCol; //768 pixels
	/**
	 * sets up the height of the GUI
	 */
	public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
	/**
	 * the amount of Frames Per Second the game is running 
	 */
	
	
	//THE WORLD SETTINGS
	public final int maxWorldCol =50;
	public final int maxWorldRow =50;
	public final int worldWidth = tileSize * maxWorldCol;
	public final int worldHeight = tileSize * maxWorldRow;
	
	
	
	
	
	
	int FPS =60;
	
	TileManager tileM = new TileManager(this);
	/**
	 * sets up keyhandler to read keys
	 */
	KeyHandler keyH =new KeyHandler();
	/**
	 * sets up a game thread
	 */
	Thread gameThread;
	/**
	 *  sets up a new player and connects it to the keyhandler to move
	 */
	public Player player = new Player(this,keyH);
	
	

	
/**
 * this function sets the GUI up and allows for keyboard inputs to be read	
 */
	public GamePanel () {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	/**
	 *  this launches the game 
	 */
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	/**
	 * this is actually running the game and setting the game to 60fps to update
	 */
	public void run() {
		double drawInterval = 1000000000/FPS; //0.01666 seconds
		double nextDrawTime= System.nanoTime()+ drawInterval;
		
		while(gameThread != null) {
			
	
			update();
			
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			}
			
			catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * updates the player information such as position
	 */
	public void update() {
		player.update();
		
	}
	/**
	 * this draws things onto the display of the GUI
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		player.draw(g2);
		
		g2.dispose();
	}
}
