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
	
	
	Deck deck;
	Hand hand;
	boolean first = false; 
	boolean alive = true;  
	
	
	
	public Player(){
		
	}
	void setup(){
		if(first == true){
			health = 100;
			for(int i=0; i<5; i++)//draw 5 starting
				drawCard();
			
		}
		else{
			health = 105;//going seconds stats
			for(int i=0; i<5; i++)//draw 5 starting
				drawCard();
		}
		
			
	}
	void phase1(){ //players take their turns
		drawCard();
		upkeep();//where mana burn happens
		drawormana();
		
	}
	/*
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
	
	*/
	public void loadDeck(String fileName){
		deck.loadDeck(fileName);
	}
	void playedcard(Card c){
		hand.removeCard(c);
	}
	void drawCard(){ //how one draws a card
		hand.addCard(deck.drawCard());
		//System.out.println(DeckList[TopDeck]);//topdeck is locating the top card on your deck
		//TopDeck = TopDeck+1;	
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
	
	
	
	void start() {first = true;}
	void upkeep(){
		health=health - (black+white+grey);
	}
	void drawormana() {
		String choice = "add stat s"; //add method to get choice from gui, draw or mana or +1 stat, idk
		switch (choice){
			case "draw":
				drawCard();
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
				drawCard();
				
		}
	}
}
