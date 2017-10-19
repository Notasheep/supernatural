package logik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import character.Character;

import data.ReadCharacterFile;

public class CharacterContainer extends Observable implements Iterator<Character> {

	private static CharacterContainer charcon = null;
	public ArrayList<Character> charconList = new ArrayList<Character>();
	private int index = 0;
	
	private CharacterContainer(){
	}
	
	public static CharacterContainer instance(){
		if (charcon == null){
			charcon = new CharacterContainer();
			@SuppressWarnings("unused")
			ReadCharacterFile read = new ReadCharacterFile(charcon);
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
