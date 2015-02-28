package CardGame;

public class DeckCreationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String reason;
	public DeckCreationException(String message){
		reason=message;
		System.out.println(message);
		
	}
}
