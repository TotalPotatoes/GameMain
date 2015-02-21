package CardGame;

//import java.io.IOException;

public class DeckBuilder {
	
	//public static void main(String[] args) throws IOException {
	 DeckBuilder() {
		//take input for deck name
		String GivenName="test";
		String TopDeckCard="";
		
		
		System.out.println("Name Deck");
		//Name = GuiDeckBuilder.EnteredName //pulls deck name from Gui
		DeckObject Deck = new DeckObject();		
		Deck.Name(GivenName);
		

		

		for (int i=0; i<40; i++){
			//System.out.println("The card @" + i+1 + "="+Deck.DeckList[i]+"do you want to change it? y/n");//Name/get the card for position x
			boolean changecard=true;
					
			if(changecard=true)
			{
				TopDeckCard="pull name of new card here";
				Deck.Addcard(i, TopDeckCard);
			}
				
				

				
		}
		for (int i=0; i<40; i++){
			Deck.Addcard(i, "lol");
		}
		//Deck.SaveDeck();
		//Deck.LoadDeck(GivenName);
		//gameplay newgame = new gameplay();
		
		
	}

}
