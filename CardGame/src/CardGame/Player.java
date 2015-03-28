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
	 * @param card
	 * @return
	 */
	public boolean canCast(Card card){
		int temp[]=card.getCost();
		int leftOver[]=new int[temp.length];
		leftOver[0]=temp[0]-black;//how much black mana is left over
		leftOver[1]=temp[1]-grey;//how much grey mana is left over
		leftOver[2]=temp[2]-white;//how much white mana is left over
		leftOver[3]=leftOver[0]+leftOver[1]+leftOver[2]-temp[3];
		
		for(int a=0; a<leftOver.length; a++){
			if(leftOver[a]<0){
				return false;
			}
		}
		return true;	
	}
	/**
	 * this does the actual casting. 
	 * @param card
	 */
	public void cast(Card card){
		int temp[]=card.getCost();
		black=black-temp[0];
		grey=grey-temp[1];
		white=white-temp[2];
		chooseMana(temp[3]);
		hand.removeCard(card);
		
	}
	/**
	 * idk how to make this work yet, but basically we need to be able to get info from the user about what mana they want to use
	 * @param cost
	 */
	private void chooseMana(int cost){
		
	}
	public void loadDeck(String fileName) throws DeckCreationException{
		//System.out.println("aaaaaaaaaaa;;;;;;;;"+fileName);
		deck=new Deck(fileName);
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
	public void takeDamage(String type, int value){
		switch(type){
		case "physical":{
			if (value>armor)
			{
				health-= value-armor;
			}
		}break;
		case "magical":{
			if (value>magicResist)//as to not take negative damage thus gaining health
			{
				health-= value-magicResist;
			}break;
		}
		default:
		{
			System.out.println("Undifined type");
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
