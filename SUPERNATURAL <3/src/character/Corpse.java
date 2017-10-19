package character;


public class Corpse extends Character {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2623340002957170861L;

	public Corpse(String name) {
        super(name);
        this.setType(CharacterType.Corpse);
    }
}