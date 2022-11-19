package main;

import javax.swing.JFrame;
/**
 * Main class for the project
 * @author jlb74
 *
 */
public class Main {
	/**
	 * @param args main class
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("DND ADVENTURE GAME");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
