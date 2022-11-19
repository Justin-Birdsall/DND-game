package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * keyhandler looks for keys pressed and released
 * @author jlb74
 *
 */
public class KeyHandler implements KeyListener{
	/**
	 * true for when direction key is pressed and false when direction key is released
	 */
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	/**
	 * key typed for key pressed
	 */
	public void keyTyped(KeyEvent e) {
		
	}
	/**
	 * looks for WASD key pressed and sets boolean to true
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed=true;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed=true;
		}
		if (code == KeyEvent.VK_S) {
			downPressed=true;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed=true;
		}
		
	}
	/**
	 * turns doolean false when the WASD is released on the keyboard
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upPressed=false;
		}
		if (code == KeyEvent.VK_A) {
			leftPressed=false;
		}
		if (code == KeyEvent.VK_S) {
			downPressed=false;
		}
		if (code == KeyEvent.VK_D) {
			rightPressed=false;
		}
		
	}

}
