
package gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import character.CharacterType;

public class HuntPickDia extends Dialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 832190509465543828L;
    Button action = new Button("Kampf");
    Panel pr = new Panel();
    Panel pl = new Panel();
    List lsHunter = new List(1);
    List lsDeamon = new List(1);
    public HuntPickDia(MainWindow m) {
        super(m ,"Neue Jagd beginnen");
        this.setLayout(new BorderLayout());
        this.setModal(true);
        pr.add(lsDeamon);
        pl.add(lsHunter);
        this.add(pr, BorderLayout.EAST);
        this.add(pl, BorderLayout.WEST);
        for(character.Character c: logik.CharacterContainer.instance().charconList){
        	if(c.getType() == CharacterType.Hunter){
        		lsHunter.add(c.getName());
        	}
        	System.out.println(c.getType());
        	System.out.println(c.getName());
        }
        this.add(action, BorderLayout.SOUTH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        this.pack();
        this.setVisible(true);
    }

}
