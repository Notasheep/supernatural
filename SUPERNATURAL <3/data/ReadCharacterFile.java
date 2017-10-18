package data;

import java.io.*;
import java.util.ArrayList;

import logik.CharacterContainer;

public class ReadCharacterFile {
	ObjectInputStream objectinputstream = null;
	public ReadCharacterFile(CharacterContainer charcon) {
	try {
	    FileInputStream streamIn = new FileInputStream("G:\\address.ser");
	    objectinputstream = new ObjectInputStream(streamIn);
	    charcon.charconList= (ArrayList<logik.Character>) objectinputstream.readObject();
	} catch (Exception e) {
	    e.printStackTrace();
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