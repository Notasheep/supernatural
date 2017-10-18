package logik;

import java.util.ArrayList;

public class Character{
    public String name;
    public Integer live = 100;
    public Boolean isDead = false;
    public ArrayList<Goodies> inventory;

    public Character(String name){
        this.name = name;
        inventory = new ArrayList<Goodies>(20);
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
    	this.live -= i ;
    }
    public void sleepAndheal(Integer i){
    	this.live += i;
    }
    
    public boolean isDead(){
    	if(live <= 0) {
    		live = 0;
    		isDead = true;
    	}
    	return isDead;
    }
}