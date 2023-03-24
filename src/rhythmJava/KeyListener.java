package rhythmJava;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(GameFrame.game == null) return;
		

		if(e.getKeyCode() == KeyEvent.VK_A) GameFrame.game.pressA();
		else if(e.getKeyCode() == KeyEvent.VK_S) GameFrame.game.pressS();
		else if(e.getKeyCode() == KeyEvent.VK_D) GameFrame.game.pressD();
		else if(e.getKeyCode() == KeyEvent.VK_F) GameFrame.game.pressF();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(GameFrame.game == null) return;

		if(e.getKeyCode() == KeyEvent.VK_A) GameFrame.game.releaseA();
		else if(e.getKeyCode() == KeyEvent.VK_S) GameFrame.game.releaseS();
		else if(e.getKeyCode() == KeyEvent.VK_D) GameFrame.game.releaseD();
		else if(e.getKeyCode() == KeyEvent.VK_F) GameFrame.game.releaseF();
	}
	
}
