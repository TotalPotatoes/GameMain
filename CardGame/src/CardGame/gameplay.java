package CardGame;

import java.io.IOException;
import java.util.Random;

public class gameplay {
	
	private String deckname1;
	private String deckname2;
	DeckObject Deck1 = new DeckObject();
	DeckObject Deck2 = new DeckObject();
	
	public gameplay() throws IOException{

		//ask players for names of their decks
		Deck1.LoadDeck(deckname1);
		Deck2.LoadDeck(deckname2);
		
		//gui stuff
		
		Random random = new Random();
		int first = random.nextInt(2);
		System.out.println(first);
		if(first == 0)
		{
			Deck1.start();
			setup();
		}
		else
		{
			Deck2.start();
			setup();
		}
		
		TurnStart();{
			
		}
	}
	void setup() {
		for (int i=0; i<5; i++)
		{
			Deck1.Drawcard();
			Deck2.Drawcard();
		}
		
		
	}
	void TurnStart() {
		
		
	}

	
	
}
