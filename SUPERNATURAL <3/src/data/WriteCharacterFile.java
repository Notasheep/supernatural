package data;

import java.io.*;

import logik.CharacterContainer;

public class WriteCharacterFile {
	
    public void saveAllCharacters(CharacterContainer charcon){
    	try{
    		File file = new File("Characters.txt");
	        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
	        out.writeObject(charcon.charconList);
	        out.flush();
	        out.close();
	        System.out.println("Object written to file");
	    } catch (FileNotFoundException ex) {
	        System.out.println("Error with specified file") ;
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        System.out.println("Error with I/O processes") ;
	        ex.printStackTrace();
	    }             
	}

}	