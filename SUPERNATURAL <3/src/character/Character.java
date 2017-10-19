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
    private ArrayList<Goodies> inventory = new ArrayList<Goodies>(20);
    protected CharacterType type;
    

    public Character(String name){
        this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    public void setName(String name){
    	if(checkName(name)){
    		this.name = name;
    	}
    }
    private Boolean checkName(String name){
    	return (name.length()< 21);
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

	public ArrayList<Goodies> getInventory() {
		return inventory;
	}

	public void linkInventory(Goodies g) {
		this.inventory.add(g);
	}
	
	public void unlinkInventory(Goodies g){
		this.inventory.remove(g);
	}
	
	public CharacterType getType() {
		return this.type;
	}

	public Integer getLive() {
		return live;
	}

	public void setLive(Integer live) {
		this.live = live;
	}
	
	public void setType(CharacterType type){
		this.type = type;
	}
}