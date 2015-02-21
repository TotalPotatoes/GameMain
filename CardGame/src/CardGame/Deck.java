package CardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Deck {
	

	private String name="DefaultDeck";//the name of the deck
	private Card[] deckList = new Card[40];//the number is the deck size
	private boolean first = false; //dafuq is this?
	private int topDeck = 0;//where you currently are in your deck, ie when you draw 7 cards you go down 7 
		
	public void replaceCardAt(int position,Card c){
		deckList[position]= c;				
	}
	/**
	 * i don't even know what the point of this is....?
	 */
	public Card drawCard(){
		topDeck = topDeck+1;
		return deckList[topDeck-1];
	}
	
	public void setName(String inputName){
		name= inputName;
	}
	
	public Card topDeckName()
	{
		return deckList[topDeck];
	}
	
	//static void writeStringToFile(File file, String data)
	/**
	 * this should probably be removed. not much point of it
	 * saving/creating/editing deckLists should be done by somethign esle
	 * @throws IOException
	 */
	public void saveDeck() throws IOException
	{
		System.out.println("Saving");
		File SavedList = new File(name);
		SavedList.createNewFile();
		FileWriter writer = new FileWriter(SavedList);
		
		    for (int i=0; i<40; i++)
		    {		    	
				writer.write( deckList[i]+"\n");
		    }	  
		    writer.close( );
	
	}
	/**
	 * this loads a deck from the specified file
	 * format of the file should be 1 line per card
	 * @param fileName the location of the deckFile
	 */
	public void loadDeck(String fileName)
	{
		File file=new File(fileName);
		try {
			Scanner fRead=new Scanner(file);
			int count=0;
			while(fRead.hasNext()){
				deckList[count]=new Card(fRead.nextLine());
				count++;
				if(count>=40){
					fRead.close();
					break;
				}
				
			}
			fRead.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void start() {
		first = true;
	}

}
 