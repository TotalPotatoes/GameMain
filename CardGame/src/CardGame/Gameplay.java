package CardGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * will have to refactor the class to start with a capital letter.
 * @author Bernard Serbinowski
 *
 */
public class Gameplay implements Runnable{
	
	//Player player1 = new Player();
	//Player player2 = new Player();//this shuld probably be changed to an arrayList or some shit
	private ArrayList<Player> players=new ArrayList<Player>();
	private int playerturn=0;
	
	public Gameplay() throws IOException, DeckCreationException{
		Thread t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		Player activePlayer;
		while(true){
			activePlayer=players.get(playerturn);
			activePlayer.drawOrMana();
			//do stuff that i don't know what it does yet.
			try {
				//this.repaint();
				Thread.sleep(50);
			} catch (InterruptedException ex) {
				Logger.getLogger(Gameplay.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		// TODO Auto-generated method stub
		
	}	
}
