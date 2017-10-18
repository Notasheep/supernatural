package logik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class CharacterContainer extends Observable implements Iterator<Character> {

	private static CharacterContainer charcon = null;
	public static ArrayList<Character> charconList = new ArrayList<Character>();
	private int index = 0;
	
	private CharacterContainer(){
	}
	
	public static CharacterContainer instance(){
		if (charcon == null){
			charcon = new CharacterContainer();
		}
		return charcon;
	}

	public boolean hasNext() {
		 return !(charconList.size() == index);
	}

	public Character next() {
		 if(hasNext()) {
			 Character a = charconList.get(index++);
	            return a;
	        } else {
	        return null;
	        }
	}
	
	public void add(Character charadding){
		charconList.add(charadding);
		setChanged();
		notifyObservers();
	}
}
