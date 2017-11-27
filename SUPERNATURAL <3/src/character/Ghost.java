package character;


public class Ghost extends Bad {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2623340002957170861L;

	public Ghost(String name) {
        super(name);
        this.setType(CharacterType.Ghost);
        setLive(200);
        setUntouchable(true);
        setNextLevelAt(20);
    }
}