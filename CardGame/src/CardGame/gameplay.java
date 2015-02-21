package CardGame;

import java.io.IOException;
import java.util.Random;

public class gameplay {
	
	private String deckname1;
	private String deckname2;
	Player player1 = new Player();
	Player player2 = new Player();
	Deck Deck1 = new Deck();
	Deck Deck2 = new Deck();
	int playerturn;
	
	public gameplay() throws IOException{

		//ask players for names of their decks
		player1.loadDeck(deckname1);
		player2.loadDeck(deckname2);
		
		//gui stuff
		
		Random random = new Random();
		int first = random.nextInt(2)+1;
		playerturn=first;
		System.out.println(first);
		if(first == 1)
		{
			player1.start();
			setup();
		}
		else
		{
			player2.start();
			setup();
		}
		
		play();

	}
	
	
	
	void setup(){
		player1.setup();
		player2.setup();
	}
		
	void play() {
		while(player1.getAlive() == true && player2.getAlive() == true){
			if(playerturn==1){				
				player1.phase1();//draw/upkeep/draw or mana or stats
				//player1.cast();
				
				playerturn=2;
			}
			if(playerturn==2){
				player2.phase1();
				//player2.cast();
				
				
				playerturn=1; //or 3 for players >2
			}									
		}	
	}	
}
