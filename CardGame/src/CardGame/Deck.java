package CardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * would suggest switching away from array
 * @author Bernard Serbinowski
 *
 */
public class Deck {
	
	private static final int size=40;
	private ArrayList<Card> deckList=new ArrayList<Card>();
	
		
	public void replaceCardAt(int position,Card c){
		deckList.set(position, c);	
	}
	/**
	 * returns and removes the top card
	 */
	public Card drawCard(){
		return deckList.remove(0);
	}
	
	/**
	 * returns the top card without removing it
	 * @return the top card
	 */
	public Card peekAtTopCard()
	{
		return deckList.get(0);
	}
	/**
	 * i think should draw the top x cards???
	 * @param x
	 * @return
	 */
	public Card[] drawXCards(int x){
		Card[] returner=new Card[x];
		returner=deckList.subList(0, x).toArray(returner);
		deckList.subList(0, x).clear();
		return returner;
	}
	public Deck(String file) throws DeckCreationException{
		loadDeck(file);
	}
	/**
	 * this loads a deck from the specified file
	 * format of the file should be 1 line per card
	 * @param fileName the location of the deckFile
	 * @throws DeckCreationException 
	 */
	public void loadDeck(String fileName) throws DeckCreationException
	{
		File file=new File(fileName);
		try {
			Scanner fRead=new Scanner(file);
			int count=0;
			while(fRead.hasNext()){
				deckList.add(new Card(fRead.nextLine()));
				count++;
				if(count>size){
					fRead.close();
					throw new DeckCreationException("too many cards: "+count+". max allowed: "+size);
				}
				
			}
			fRead.close();
			if(count<40){
				throw new DeckCreationException("too few cards: "+count);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DeckCreationException("file not found");
		}
	}
	

}
 
