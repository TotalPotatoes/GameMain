package CardGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DeckObject {
	

	private String name="DefaultDeck";//the name of the deck
	String[] DeckList = new String[40];//the number is the deck size
	private int TopDeck = 0;//where you currently are in your deck, ie when you draw 7 cards you go down 7 
		
	void Addcard(int position,String cardname){
		DeckList[position]= cardname;				
	}
	
	void Drawcard(int drawn){
		System.out.println(DeckList[TopDeck]);
		TopDeck = TopDeck+drawn;	
	}
	
	void Name(String inputName){
		name= inputName;
	}
	
	void TopDeckName()
	{
		System.out.println(DeckList[TopDeck]);
	}
	
	//static void writeStringToFile(File file, String data)

	void SaveDeck() throws IOException
	{
		BufferedWriter SavedList = null;
		{
		    SavedList = new BufferedWriter( new FileWriter( name));
		    for (int i=0; i<40; i++)
		    {
		    	SavedList.write( DeckList[i]);
		    }
	  
		    SavedList.close( );
		}

	}
	
	void LoadDeck()
	{
			
	}
} 
