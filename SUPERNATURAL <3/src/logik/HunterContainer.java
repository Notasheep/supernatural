package logik;

import java.util.ArrayList;
import java.util.Iterator;

public class HunterContainer implements Iterator<Hunter> {

    private static HunterContainer huncon = null;
    public ArrayList<Hunter> hunconList = new ArrayList<Hunter>();
    private int index = 0;

    private HunterContainer(){
    }

    public static HunterContainer instance(){
        if (huncon == null){
            huncon = new HunterContainer();
            for (Character c: CharacterContainer.instance().charconList)
            if (c.getType() == "Hunter"){
            	huncon.add((Hunter)c);
            }
        }
        return huncon;
    }

    public boolean hasNext() {
        return !(hunconList.size() == index);
    }

    public Hunter next() {
        if(hasNext()) {
            Hunter b = hunconList.get(index++);
            return b;
        } else {
            return null;
        }
    }

    public void add(Hunter charadding){
    	hunconList.add(charadding);
    }
}