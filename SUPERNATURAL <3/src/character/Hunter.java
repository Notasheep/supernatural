package character;


public class Hunter extends Good{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5329686888759530473L;

	public Hunter(String name) {
		super(name);
		this.type = CharacterType.Hunter;
	}
}
