package CardGame;

import java.util.ArrayList;
/**
 * this just stores information about what is in the players hand.
 * allows for removal, replacement, and someother stuff
 * @author Bernard Serbinowski
 *
 */
public class Hand {
	private Player owner;
	private ArrayList<Card> cards;
	
	public Hand(Player p){
		owner=p;
	}
	public Player getOwner(){
		return owner;
	}
	public ArrayList<Card> getCards(){
		return cards;
	}
	public void removeCard(Card c){
		cards.remove(c);
	}
	/**
	 * note that this will add card d regardless of whether c is present or not
	 * @param c
	 * @param d
	 */
	public void replaceCard(Card c, Card d){
		cards.remove(c);
		cards.add(d);
	}
	public void addCard(Card c){
		cards.add(c);
	}
	public void clearHand(){
		cards.clear();
	}
	public int getHandSize(){
		return cards.size();
	}

}
