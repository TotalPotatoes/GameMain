package CardGame;

import java.util.ArrayList;

public class Keyword {
	private String keyName;
	/**
	 * a constructor.
	 * @param key
	 * @param targets
	 * @param value
	 */
	public Keyword(String key, ArrayList<Player> targets, int value){
		keyName=key;
	}
	public Keyword(String key){
		
	}
	/**
	 * returns the name of the keyword
	 * @return
	 */
	public String getKey(){
		return keyName;
	}
}
