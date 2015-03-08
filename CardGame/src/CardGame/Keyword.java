package CardGame;

import java.util.ArrayList;

public class Keyword {
	private String keyName;
	private String targets;
	private int values;
	/**
	 * a constructor.
	 * @param key
	 * @param targets
	 * @param value
	 */
	public Keyword(String key, String ts, int vals){
		keyName=key;
		targets=ts;
		values=vals;
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
	public String getTargets(){
		return targets;
	}
	public int getValues(){
		return values;
	}
}
