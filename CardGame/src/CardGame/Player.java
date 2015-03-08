package CardGame;


/**
 * 
 * @author Bernard Serbinowski
 * @author Seth Zebrack
 */
public class Player {
	//attributes
	private int health=100;//how much health the player has
	private int armor=0;//how much armor the player has
	private int magicResist=0;;//how much magic resist the player has
	private int speed=10;//how much speed the player has
	private int intellect=0;//how much intellect the player has
	private int attack=1;
	private int strength=0;
	private int spellPower=0;
	private int spellSpeed=10;
	private int black=0;
	private int white=0;
	private int grey=0;
	
	
	private Deck deck;
	private Hand hand;
	private boolean first = false; 
	private boolean alive = true;  
	
	
	/**
	 * constructor for the player class
	 */
	public Player(){
		
	}
	/**
	 * no clue what thid does...
	 */
	public void setup(){
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
	/**
	 * 
	 * @param cast
	 */
	public void cast(Card castedcard){
		playedCard(castedcard);	
	}
	
	public void loadDeck(String fileName) throws DeckCreationException{
		deck.loadDeck(fileName);
	}
	
	public void playedCard(Card c){
		hand.removeCard(c);
	}
	
	public void drawCard(){ //how one draws a card
		hand.addCard(deck.drawCard());
		//System.out.println(DeckList[TopDeck]);//topdeck is locating the top card on your deck
		//TopDeck = TopDeck+1;	
	}
	
	public void addStat(String stat, int value){
		switch(stat){
			case "health":{
				health+=value;
				break;
			}
			case "armor":{
				armor+=value;
				break;
			}
			case "magicResist":{
				magicResist+=value;
				break;
			}
			case "speed":{
				speed+=value;
				break;
				
			}
			case "intellect":{
				intellect+=value;
				break;
			}
			case "attack":{
				attack+=value;
				break;
			}
			case "strength":{
				strength+=value;
				break;
			}
			case "spellPower":{
				spellPower+=value;
				break;
				
			}
			case "spellSpeed":{
				spellSpeed+=value;
				break;
			}
			default:
			{
				System.out.println("Unidentified stat");
				break;
			}
		}
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	/**
	 * i have no idea what this does
	 */
	public void start() {first = true;}
	/**
	 * does upkeep stuff
	 */
	public void upkeep(){
		health=health - (black+white+grey);
	}
	public void drawOrMana() {
		String choice = "add stat s"; //add method to get choice from gui, draw or mana or +1 stat, idk
		switch (choice){
			case "draw":
				drawCard();
				break;
			case "mana":
				//mana();
				break;
			case "add stat s":
				addStat("strength", 1);
				break;
			case "add stat i":
				addStat("intellect", 1);
				break;
			default:
				drawCard();
				
		}
	}
}
