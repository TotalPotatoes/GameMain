package CardGame;
/**
 * 
 * @author Bernard Serbinowski
 *
 */
public class Player {
	//attributes
	private int health;//how much health the player has
	private int armor;//how much armor the player has
	private int magicResist;//how much magic resist the player has
	private int speed;//how much speed the player has
	private int intelect;//how much intelect the player has
	//consideration: spell speed should be based off of a stat? for instance, if i have a high spell speed stat, i have an easier time casting counterspells then you do
	private Object hand;//this is the players hand. not sure how this should be stored yet (should hand be a class? or just an array of cards? don't know yet)
	public Player(){
		
	}
}
