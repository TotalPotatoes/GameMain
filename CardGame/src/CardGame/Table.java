package CardGame;

import java.util.ArrayList;

/**
 * this is just like, the table on which the card game is played. has who is playing, what's on the field, will probably have a field object. idk yet
 * @author Bernard Serbinowski
 *
 */
public class Table {

	private Player[] players;//this is the total amount of players
	private ArrayList<Card> activeCards;//what cards are on the field
	private Field field;
	
	public Table(){
		
	}
}
