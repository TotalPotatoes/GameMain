package CardGame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Bernard Serbinowski
 * @author Seth Zebrack
 */
public class Player {
	//attributes
	int health=100;//how much health the player has
	int armor=0;//how much armor the player has
	int magicresist=0;;//how much magic resist the player has
	int speed=10;//how much speed the player has
	int intellect=0;//how much intellect the player has
	int attack=1;
	int strength=0;
	int spellpower=0;
	int spellspeed=10;
	int ttm=0;
	int black=0;
	int white=0;
	int grey=0;
	
	
	private String name="DefaultDeck";//the name of the deck
	String[] DeckList = new String[40];//the number is the deck size
	boolean first = false; 
	boolean alive = true; 
	private int TopDeck = 0;//where you currently are in your deck, ie when you draw 7 cards you go down 7 
	
	//consideration: spell speed should be based off of a stat? for instance, if i have a high spell speed stat, i have an easier time casting counterspells then you do
	//private Object inhand;//this is the players hand. not sure how this should be stored yet (should hand be a class? or just an array of cards? don't know yet)
	ArrayList<String> hand = new ArrayList<String>();
	
	
	public Player(){
		
	}
	void setup(){
		if(first == true){
			health = 100;
			for(int i=0; i<5; i++)//draw 5 starting
				Drawcard();
			
		}
		else{
			health = 105;//going seconds stats
			for(int i=0; i<5; i++)//draw 5 starting
				Drawcard();
		}
		
			
	}
	void phase1(){ //players take their turns
		Drawcard();
		upkeep();//where mana burn happens
		drawormana();
		
	}
	void cast() {
		String Casting="";
		for(int i = 0; i<hand.size();i++)
			System.out.println(hand.get(i));//print this to gui to show what cards you have in hand// dont display here in casting, do it in general or something
			
		int x=0;//x is the chosen card to cast. with 0 being the first card
		if(x<hand.size()){
			Casting=hand.get(x);//gets name of card casted for the casting purpose
			playedcard(x);//removes from hand
		}
		else{
			
		}
		
		
	}
	
	void Addcard(int position,String cardname){
		DeckList[position]= cardname;				
	}
	
	void playedcard(int playloc){
		hand.remove(playloc);
	}
	void Drawcard(){ //how one draws a card
		hand.add(DeckList[TopDeck]);
		System.out.println(DeckList[TopDeck]);//topdeck is locating the top card on your deck
		TopDeck = TopDeck+1;	
	}
	
	void mana(){
		//method to convert card to mana
	}
	void addstats(){
		strength++;
	}
	void addstati(){
		intellect++;
	}
	
	void Name(String inputName){
		name= inputName;
	}
	
	void TopDeckName()
	{
		System.out.println(DeckList[TopDeck]);
	}
	
	void SaveDeck() throws IOException
	{
		System.out.println("Saving");
		File SavedList = new File(name);
		SavedList.createNewFile();
		FileWriter writer = new FileWriter(SavedList);
		
		    for (int i=0; i<40; i++)
		    {		    	
				writer.write( DeckList[i]+"\n");
		    }	  
		    writer.close( );
	
	}
	
	void LoadDeck(String LoadName) throws IOException
	{
		for (int i=0; i<40; i++)
	    {		    	
			DeckList[i]="";
	    }
	}
	
	
	void start() {first = true;}
	void upkeep(){
		health=health - (black+white+grey);
	}
	void drawormana() {
		String choice = "add stat s"; //add method to get choice from gui, draw or mana or +1 stat, idk
		switch (choice){
			case "draw":
				Drawcard();
				break;
			case "mana":
				mana();
				break;
			case "add stat s":
				addstats();
				break;
			case "add stat i":
				addstati();
				break;
			default:
				Drawcard();
				
		}
	}
}
