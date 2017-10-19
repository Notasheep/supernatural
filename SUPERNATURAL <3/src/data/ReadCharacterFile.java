package data;

import java.io.*;
import java.util.ArrayList;

import logik.CharacterContainer;

public class ReadCharacterFile {
	ObjectInputStream objectinputstream = null;
	@SuppressWarnings("unchecked")
	public ReadCharacterFile(CharacterContainer charcon) {
	try {
	    FileInputStream streamIn = new FileInputStream("Data/AllCharacters.txt");
	    objectinputstream = new ObjectInputStream(streamIn);
	    charcon.charconList = (ArrayList<character.Character>) objectinputstream.readObject();
	} catch (Exception e) {
	    e.printStackTrace();
	    charcon.charconList = new ArrayList<character.Character>();
	} finally {
	    if(objectinputstream != null){
	        try {
				objectinputstream .close();
			} catch (IOException e) {
				System.err.println("That didn't go as planned...");
			}
	    } 
	}
}
}