package character;

import java.io.Serializable;
import java.util.ArrayList;

import logik.Goodies;

public class Character implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6473100962818838465L;
	private String name;
    private Integer live = 100;
    private Boolean isDead = false;
    private Integer experiencePoints = 0;
    private Integer nextLevelAt = 50;
    private Integer level = 0;
    private ArrayList<Goodies> inventory = new ArrayList<Goodies>(20);
    protected CharacterType type; 
    
    //Constructor
    public Character(String name)throws IllegalArgumentException {
        this.setName(name);
    }
    
    //Methods
    		//Main attrebutes
    			//Name
    public String getName() {
    	return this.name;
    }
    private void setName(String name) throws IllegalArgumentException {
    	if(checkName(name)){
    		this.name = name;
    	} else {
    		throw new IllegalArgumentException("Der Name ist zu kurz, oder zu lang.");
    	}
    }
    private Boolean checkName(String name){
    	return (name.length()< 21 && name != null && name.length() > 0);
    }
    
    			//live
    public Integer getLive() {
		return live;
	}
	public void setLive(Integer live) {
		this.live = live;
	}
    public void looseLive(Integer i){
    	this.setLive(this.getLive() - i) ;
    }
    public void sleepAndheal(Integer i){
    	this.setLive(this.getLive() + i);
    }
    
    public boolean isDead(){
    	if(getLive() <= 0) {
    		setLive(0);
    		isDead = true;
    	}
    	return isDead;
    }
    
			//Inventory
    public ArrayList<Goodies> getInventory() {
		return inventory;
    }
    public void linkInventory(Goodies g) {
    		this.inventory.add(g);
	}
	public void unlinkInventory(Goodies g){
		this.inventory.remove(g);
	}
	
			//Type
	public CharacterType getType() {
		return this.type;
	}
	public void setType(CharacterType type){
		this.type = type;
	}
	
    	//Level management
       private void levelUp(){
    	level += 1;
    	nextLevelAt = (nextLevelAt * 2) + (nextLevelAt / 100 * 23);
    }
    public void addXP(int xpPlusToGet){
    	experiencePoints += (xpPlusToGet + 100);
    	if (experiencePoints >= nextLevelAt) {
    		experiencePoints -= nextLevelAt;
    		levelUp();
    	}
    }
}