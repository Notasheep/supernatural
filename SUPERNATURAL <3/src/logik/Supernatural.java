package logik;

import gui.PickOne;

public class Supernatural {
		  public static void main(String []args){
		    PickOne Erschaffe = new PickOne();
		    Hunter dean = new Hunter("Dean");
		    Hunter sam = new Hunter("Sam");
		    CharacterContainer ccMain= CharacterContainer.instance();
		    ccMain.add(dean);
		    ccMain.add(sam);
		    Fight a = new Fight(dean, sam);
		  }// all the shit i wonna see
}
