
package logik;

import java.util.ArrayList;
import java.util.Iterator;

public class LeichenContainer implements Iterator<Leichen> {

    private static LeichenContainer leicon = null;
    public ArrayList<Leichen> leiconList = new ArrayList<Leichen>();
    private int index = 0;

    private LeichenContainer(){
    }

    public LeichenContainer instance(){
        if (leicon == null){
            leicon = new LeichenContainer();
            return leicon;
        }
        return leicon;
    }

    public boolean hasNext() {
        return !(leiconList.size() == index);
    }

    public Leichen next() {
        if(hasNext()) {
            Leichen b = leiconList.get(index++);
            return b;
        } else {
            return null;
        }
    }
}