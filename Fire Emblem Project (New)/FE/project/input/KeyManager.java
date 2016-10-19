package FE.project.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys;
	public boolean up, down, left, right, enter, exit; // e is enter, q is exit
	
	public KeyManager(){
		keys = new boolean [256];
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		enter = keys[KeyEvent.VK_E];
		exit = keys[KeyEvent.VK_Q];
		}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e){
		keys[e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e){
		
	}
}
