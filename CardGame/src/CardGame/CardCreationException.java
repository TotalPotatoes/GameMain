package CardGame;

public class CardCreationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String reason;
	public CardCreationException(String message){
		reason=message;
		System.out.println(message);
		
	}
}
