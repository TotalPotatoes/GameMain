package CardGame;

//import java.io.IOException;

public class DeckBuilder {
	
	//public static void main(String[] args) throws IOException {
	 DeckBuilder() throws DeckCreationException{
		//take input for deck name
		String topDeckCard="";
		
		
		Deck deck = new Deck("lol");		
		

		

		for (int i=0; i<40; i++){
			//System.out.println("The card @" + i+1 + "="+Deck.DeckList[i]+"do you want to change it? y/n");//Name/get the card for position x
			boolean changecard=true;
					
			if(changecard==true)
			{
				topDeckCard="pull name of new card here";
				deck.replaceCardAt(i, new Card(topDeckCard));
			}
				
				

				
		}
		for (int i=0; i<40; i++){
			deck.replaceCardAt(i, new Card("lol"));
		}
		
		
	}

}
